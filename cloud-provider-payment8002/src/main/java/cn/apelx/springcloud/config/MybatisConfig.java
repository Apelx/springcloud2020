package cn.apelx.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 配置类
 *
 * @author lx
 * @since 2020/4/30 9:27
 */
@Configuration
@MapperScan("cn.apelx.springcloud.mapper")
public class MybatisConfig {
}
