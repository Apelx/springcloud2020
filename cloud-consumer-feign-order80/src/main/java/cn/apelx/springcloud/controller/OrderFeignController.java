package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.model.CommonResponse;
import cn.apelx.springcloud.service.FeignPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单 Feign Controller
 *
 * @author lx
 * @since 2020/6/6 17:11
 */
@RestController
@RequestMapping(value = "/order/feign", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderFeignController {

    private FeignPaymentService feignPaymentService;

    @GetMapping(value = "/consumer/payment/get/{payId}")
    public CommonResponse<Payment> getPaymentById(@PathVariable("payId") Long payId) {
        return feignPaymentService.findById(payId);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return feignPaymentService.paymentFeignTimeout();
    }

    @Autowired
    public void setFeignPaymentService(FeignPaymentService feignPaymentService) {
        this.feignPaymentService = feignPaymentService;
    }

}
