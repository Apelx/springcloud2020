package cn.apelx.springcloud.service;

import cn.apelx.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 账户接口
 *
 * @author lx
 * @since 2020/7/10 18:53
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 账户扣款
     *
     * @param userId 用户ID
     * @param money  扣款金额
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decreaseAccountMoney(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
