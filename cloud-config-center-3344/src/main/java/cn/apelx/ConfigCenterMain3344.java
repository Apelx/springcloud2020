package cn.apelx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 主启动类
 *
 * @author apelx
 * @since 2020/6/29 14:52
 */
@SpringBootApplication
@EnableConfigServer
//@ServletComponentScan(basePackages = {"cn.apelx.filter"})
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
