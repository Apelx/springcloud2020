package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.dao.AccountDAO;
import cn.apelx.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 账户接口实现类
 *
 * @author lx
 * @since 2020/7/11 0:16
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  扣减额度
     */
    @Override
    public void decreaseAccount(Long userId, BigDecimal money) {
        log.info("------> accountService 扣减账户余额开始");
        // 模拟超时业务，全局事务回滚
      /*  try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        accountDAO.decreaseAccount(userId, money);
        log.info("------> accountService 扣减账户余额结束");
    }

    @Autowired
    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
