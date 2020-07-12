package cn.apelx.rule.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon 自定义 iRule 配置类
 *
 * @author lx
 * @since 2020/5/28 22:00
 */
@Configuration
@Slf4j
public class IRuleConfig {

    /**
     * 配置随机
     *
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
