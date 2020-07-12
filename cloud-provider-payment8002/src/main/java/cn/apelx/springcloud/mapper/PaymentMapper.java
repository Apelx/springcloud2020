package cn.apelx.springcloud.mapper;

import cn.apelx.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 支付Mapper
 *
 * @author lx
 * @since 2020/4/30 9:22
 */
public interface PaymentMapper {

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
