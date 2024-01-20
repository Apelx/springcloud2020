package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单 Hystrix controller
 *
 * @author lx
 * @since 2020/6/8 22:56
 */
@RestController
@RequestMapping(value = "/consumer/payment/hystrix")
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
//    @HystrixCommand
    @GetMapping(value = "/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
//        int age = 10 /0;
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    /**
     * 服务容错方法
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id) {
        return "我是消费者80, 对方支付系统繁忙或自己运行出错, 请检查自己或请10秒钟后再试,/(ㄒoㄒ)/~~ \tid:" + id;
    }

    /**
     * 下面是全局fallBack方法
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
