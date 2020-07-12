package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.CommonResult;
import cn.apelx.springcloud.domain.Order;
import cn.apelx.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 订单Controller
 *
 * @author lx
 * @since 2020/7/10 20:53
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderController {

    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult<Order> createOrder(Order order) {
        orderService.createOrder(order);
        return new CommonResult<>(200, "订单创建成功");
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
