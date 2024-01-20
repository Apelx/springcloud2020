package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.model.CommonResponse;
import cn.apelx.springcloud.service.PaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * 断路器 Controller
 *
 * @author lx
 * @since 2020/7/10 8:48
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/fallback/{id}")
    // 没有配置
//    @SentinelResource(value = "fallback")
//     fallback只负责业务异常
//     @SentinelResource(value = "fallback", fallback = "handlerFallback")
//     blockHandler 只负责sentinel控制台配置违规
//     @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler" ,
            // 注意：无法忽略BlockException
            exceptionsToIgnore = {BlockException.class})
//            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResponse<Payment> fallback(@PathVariable(value = "id") Long id) {
        CommonResponse<Payment> response = restTemplate.getForObject(serverUrl + "/paymentSQL/" + id, CommonResponse.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常");
        } else {
            assert response != null;
            if (response.getData() == null) {
                throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常");
            }
        }
        return response;
    }

    public CommonResponse<Payment> handlerFallback(@PathVariable Long id, Throwable ex) {
        Payment payment = new Payment(id, "null");
        return new CommonResponse<>(444, "兜底异常(管runtimeException)handlerFallback, exception 内容：" + ex.getMessage(), payment);
    }

    public CommonResponse<Payment> blockHandler(@PathVariable(value = "id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, "哇哈哈哈");
        return new CommonResponse<>(445, "blockHandler-sentinel限流(管sentinel配置异常),无此流水：blockException 内容：" + blockException.getMessage(), payment);
    }


    // ########################################### OpenFeign
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResponse<Payment> openfeign(@PathVariable(value = "id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
