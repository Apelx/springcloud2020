package cn.apelx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主启动类
 *
 * @author lx
 * @since 2020/5/27 21:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainConsulOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(MainConsulOrder80.class, args);
    }
}
