package cn.apelx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 *
 * @author lx
 * @since 2020/5/27 19:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainConsulPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(MainConsulPayment8006.class, args);
    }
}
