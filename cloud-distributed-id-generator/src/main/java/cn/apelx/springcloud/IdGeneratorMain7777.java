package cn.apelx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 *
 * @author lx
 * @since 2020/7/11 16:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IdGeneratorMain7777 {
    public static void main(String[] args) {
        SpringApplication.run(IdGeneratorMain7777.class, args);
    }
}
