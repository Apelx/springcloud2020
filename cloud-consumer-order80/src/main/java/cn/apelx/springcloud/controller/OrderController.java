package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.lb.LoadBalancer;
import cn.apelx.springcloud.model.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 订单 Controller
 *
 * @author lx
 * @since 2020/4/30 10:56
 */
@RestController
@RequestMapping(value = "consumer/order", produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    private RestTemplate restTemplate;
    private LoadBalancer loadBalancer;
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/save")
    public CommonResponse<Payment> savePayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/save", payment, CommonResponse.class);
    }

    @GetMapping(value = "/get/{payId}")
    public CommonResponse<Payment> getPayment(@PathVariable("payId") Long payId) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + payId, CommonResponse.class);
    }

    @GetMapping(value = "/getError/{payId}")
    public CommonResponse<Payment> getPaymentError(@PathVariable("payId") Long payId) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getError/" + payId, CommonResponse.class);
    }

    @GetMapping(value = "/getForEntity/{payId}")
    public CommonResponse<Payment> getForEntityPayment(@PathVariable("payId") Long payId) {
        ResponseEntity<CommonResponse> responseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + payId, CommonResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return new CommonResponse<>(520, "调用失败");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        if (serviceInstance == null) {
            return "自定义loadBalancer获取服务失败";
        }
        return restTemplate.getForObject(serviceInstance.getUri() + "/payment/lb", String.class);
    }


    /**
     * 链路跟踪消费端
     *
     * @return
     */
    @GetMapping(value = "/zipkin")
    public String paymentZipkin() {
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return restTemplate.getForObject( "http://localhost:8001/payment/zipkin", String.class);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setLoadBalancer(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }
}
