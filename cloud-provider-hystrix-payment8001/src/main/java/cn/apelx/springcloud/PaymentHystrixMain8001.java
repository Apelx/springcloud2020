package cn.apelx.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import jakarta.servlet.Servlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * 主启动类
 *
 * @author lx
 * @since 2020/6/8 22:03
 */
@SpringBootApplication
//@EnableCircuitBreaker
@EnableHystrix
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springCloud升级后的坑
     * ServletRegistrationBean 因为springboot的默认路径不是"/hystrix.stream"
     * 只要在自己的项目里配置上下面的servlet就可以了
     *
     * @return
     */
    /*@Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean((Servlet) streamServlet, "/hystrix.stream");
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/
}
