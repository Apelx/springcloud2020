package cn.apelx.springcloud.service;

import cn.apelx.springcloud.domain.Order;

/**
 * 订单接口
 *
 * @author lx
 * @since 2020/7/10 18:51
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param order
     */
    void createOrder(Order order);
}
