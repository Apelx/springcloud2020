package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.CommonResult;
import cn.apelx.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 账户Controller
 *
 * @author lx
 * @since 2020/7/11 0:18
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    private AccountService accountService;


    @PostMapping(value = "/account/decrease")
    public CommonResult decreaseAccountMoney(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decreaseAccount(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
