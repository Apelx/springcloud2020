package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.dao.OrderDAO;
import cn.apelx.springcloud.domain.Order;
import cn.apelx.springcloud.service.AccountService;
import cn.apelx.springcloud.service.OrderService;
import cn.apelx.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单服务接口实现类
 *
 * @author lx
 * @since 2020/7/10 18:52
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private StorageService storageService;
    private AccountService accountService;

    /**
     * 创建订单
     *
     * @param order
     */
    @Override
    @GlobalTransactional(name = "order-create-tx", rollbackFor = {Exception.class})
    public void createOrder(Order order) {
        log.info("--------> 开始新建订单");
        if (order.getStatus() == null || !order.getStatus().equals(0)) {
            order.setStatus(0);
        }
        orderDAO.create(order);

        log.info("--------> 订单微服务开始调用库存，做减扣库存数量 Start >>>");
        storageService.decreaseStorage(order.getProductId(), order.getCount());
        log.info("--------> 订单微服务开始调用库存，做减扣库存数量 End >>>");

        log.info("--------> 订单微服务开始调用账户，做减扣用户金额 Start >>>");
        accountService.decreaseAccountMoney(order.getUserId(), order.getMoney());
        log.info("--------> 订单微服务开始调用账户，做减扣用户金额 End >>>");

        log.info("修改订单状态开始");
        orderDAO.updateStatus(order.getId(), 1);

        log.info("完成创建订单");
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
