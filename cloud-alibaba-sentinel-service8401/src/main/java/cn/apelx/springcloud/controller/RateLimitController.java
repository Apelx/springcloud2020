package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.handler.CustomerBlockHandler;
import cn.apelx.springcloud.model.CommonResponse;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 速率限制 控制类
 *
 * @author apelx
 * @since 2020/7/9 17:45
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class RateLimitController {

    @GetMapping(value = "/byResource", produces = {MediaType.APPLICATION_JSON_VALUE})
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResponse<Payment> byResource() {
        return new CommonResponse<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResponse<Payment> handleException(BlockException blockException) {
        return new CommonResponse<>(444, blockException + "\t 服务不可用");
    }


    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResponse<Payment> byUrl() {
        return new CommonResponse<>(200, "按url限流测试OK", new Payment(2020L, "serial1002"));
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResponse<Payment> customerBlockHandler(String p1) {
        return new CommonResponse<>(200, "按客户自定义", new Payment(2020L, "serial1003"));
    }
}
