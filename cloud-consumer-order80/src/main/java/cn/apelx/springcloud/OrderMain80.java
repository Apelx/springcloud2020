package cn.apelx.springcloud;

//import cn.apelx.rule.config.IRuleConfig;
import cn.apelx.springcloud.config.CustomLoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 订单 启动类
 *
 * @author lx
 * @since 2020/4/30 10:54
 */
@SpringBootApplication
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = {IRuleConfig.class}) // ribbon已经过时被移除
@LoadBalancerClient(value = "CLOUD-PAYMENT-SERVICE", configuration = CustomLoadBalancerConfig.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
