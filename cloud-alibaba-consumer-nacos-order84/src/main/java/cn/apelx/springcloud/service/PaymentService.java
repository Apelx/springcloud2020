package cn.apelx.springcloud.service;

import cn.apelx.springcloud.service.fallback.PaymentServiceFallback;
import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.model.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 支付 Feign 接口
 *
 * @author lx
 * @since 2020/7/10 10:24
 */
@Service
@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResponse<Payment> paymentSQL(@PathVariable(value = "id") Long id);

}
