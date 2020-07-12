package cn.apelx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单 controller
 *
 * @author lx
 * @since 2020/5/27 21:54
 */
@RestController
@RequestMapping(value = "/order", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderConsulController {

    private static final String URL = "http://cloud-consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentZk() {
        return restTemplate.getForObject(URL + "/payment/consul", String.class);
    }
}
