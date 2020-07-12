package cn.apelx.springcloud.service;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.model.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign 支付service
 *
 * @author lx
 * @since 2020/6/6 16:57
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignPaymentService {

    @GetMapping(value = "/payment/get/{payId}")
    CommonResponse<Payment> findById(@PathVariable("payId") Long payId);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
