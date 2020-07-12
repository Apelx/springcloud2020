package cn.apelx.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 账户接口
 *
 * @author lx
 * @since 2020/7/11 0:14
 */
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId 用户ID
     * @param money  扣减额度
     */
    void decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
