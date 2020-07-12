package cn.apelx.springcloud.service.fallback;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.model.CommonResponse;
import cn.apelx.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * 支付Feign接口降级类
 *
 * @author lx
 * @since 2020/7/10 10:27
 */
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public CommonResponse<Payment> paymentSQL(Long id) {
        return new CommonResponse<>(444444, "服务降级返回， --- PaymentServiceFallback", new Payment(id, "errorSerial"));
    }
}
