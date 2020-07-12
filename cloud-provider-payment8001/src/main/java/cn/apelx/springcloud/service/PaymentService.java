package cn.apelx.springcloud.service;

import cn.apelx.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 支付 service
 *
 * @author lx
 * @since 2020/4/30 9:37
 */
public interface PaymentService {
    /**
     * 保存支付实体
     *
     * @param payment
     * @return
     */
    int savePayment(Payment payment);

    /**
     * 根据ID查询支付实体
     *
     * @param payId
     * @return
     */
    Payment findById(@Param("payId") Long payId);
}
