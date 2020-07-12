package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * 支付Hystrix服务降级实现类
 * OpenFeign 调用
 *
 * @author lx
 * @since 2020/6/18 22:27
 */
@Service
public class PaymentHystrixFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "*******PaymentHystrixFallbackServiceImpl fall back - paymentInfo_OK run.";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "*******PaymentHystrixFallbackServiceImpl fall back - paymentInfo_Timeout run.";
    }
}
