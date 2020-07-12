package cn.apelx.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 配置类
 *
 * @author lx
 * @since 2020/7/10 20:55
 */
@Configuration
@MapperScan("cn.apelx.springcloud.dao")
public class MybatisConfig {
}
