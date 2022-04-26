package cn.apelx.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 负载均衡配置
 *
 * @author apelx
 * @since 2022-04-26
 */
@Configuration
public class IRuleConfig {

    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
