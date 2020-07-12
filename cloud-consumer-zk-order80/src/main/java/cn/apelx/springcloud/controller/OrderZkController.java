package cn.apelx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单 Controller
 *
 * @author lx
 * @since 2020/5/7 22:34
 */
@RestController
@RequestMapping(value = "/order", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderZkController {

    private static final String URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentZk() {
        return restTemplate.getForObject(URL + "/payment/zk", String.class);
    }
}
