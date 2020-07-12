package cn.apelx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 支付 Controller
 *
 * @author lx
 * @since 2020/5/7 22:03
 */
@RestController
@RequestMapping(value = "/payment", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/consul")
    public String paymentZk() {
        return "SpringCloud with consul : " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
