package cn.apelx.springcloud.dao;

import cn.apelx.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单DAO
 *
 * @author lx
 * @since 2020/7/10 18:11
 */
@Mapper
public interface OrderDAO {

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 修改订单状态
     *
     * @param orderId 订单ID
     * @param status  修改的状态
     * @return
     */
    int updateStatus(@Param("orderId") Long orderId, @Param("status") Integer status);
}
