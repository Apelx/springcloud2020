package cn.apelx.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon 调用规则配置
 *
 * @author apelx
 * @since 2021-08-02
 */
@Configuration
public class RibbonRuleConfig {

    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
