package cn.apelx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务端 启动类
 *
 * @author lx
 * @since 2020/4/30 14:32
 */
@SpringBootApplication
@EnableEurekaServer
// http://localhost:7001/访问eureka主页面
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
