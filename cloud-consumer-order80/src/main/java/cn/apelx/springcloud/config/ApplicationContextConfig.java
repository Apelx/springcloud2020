package cn.apelx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * applicationContext 全局配置类
 *
 * @author lx
 * @since 2020/4/30 10:55
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
