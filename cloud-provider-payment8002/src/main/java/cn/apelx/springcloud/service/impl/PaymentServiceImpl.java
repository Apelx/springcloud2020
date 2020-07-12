package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.mapper.PaymentMapper;
import cn.apelx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付Service 实现
 *
 * @author lx
 * @since 2020/4/30 9:38
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentMapper paymentMapper;

    /**
     * 保存支付实体
     *
     * @param payment
     * @return
     */
    @Override
    public int savePayment(Payment payment) {
        return paymentMapper.savePayment(payment);
    }

    /**
     * 根据ID查询支付实体
     *
     * @param payId
     * @return
     */
    @Override
    public Payment findById(Long payId) {
        return paymentMapper.findById(payId);
    }

    @Autowired
    public void setPaymentMapper(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }
}
