package cn.apelx.springcloud.config.feign_adapter;

import com.alibaba.cloud.sentinel.feign.SentinelFeign;
import feign.Contract;
import feign.Feign;
import org.aspectj.lang.annotation.After;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * TODO
 * 这是临时解决方案
 * spring cloud 2023.0.0
 * spring cloud-alibaba 2022.0.0.0 sentinel还没有适配openfeign的变动
 * 所以自定义SentinelFeign注入的IOC
 */
@Configuration
public class FeignSentinelAdapterConfig {

    @Bean
    @Scope("prototype")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "feign.sentinel.enabled")
    public Feign.Builder feignSentinelBuilder() {
        return CustomSentinelFeign.builder();
    }

}
