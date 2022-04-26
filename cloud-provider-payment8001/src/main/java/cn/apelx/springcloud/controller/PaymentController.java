package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.Payment;
import cn.apelx.springcloud.model.CommonResponse;
import cn.apelx.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 支付controller
 *
 * @author lx
 * @since 2020/4/30 9:39
 */
@RestController
@RequestMapping(value = "/payment", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PaymentController {

    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/save")
    public CommonResponse<Payment> savePayment(@RequestBody Payment payment) {
        CommonResponse<Payment> commonResponse = new CommonResponse<>();
        if (payment != null && payment.getPaySerialNumber() != null) {
            int result = paymentService.savePayment(payment);
            if (result > 0) {
                commonResponse.setCode(200);
                commonResponse.setMessage("保存成功, 端口号: " + serverPort);
                commonResponse.setData(payment);
            } else {
                commonResponse.setCode(500);
                commonResponse.setMessage("保存失败, 端口号: " + serverPort);
            }
        } else {
            commonResponse.setCode(501);
            commonResponse.setMessage("参数错误, 端口号: " + serverPort);
        }
        return commonResponse;
    }

    @GetMapping(value = "/get/{payId}")
    public CommonResponse<Payment> findById(@PathVariable("payId") Long payId) {
        CommonResponse<Payment> commonResponse = new CommonResponse<>();
        if (payId != null) {
            Payment payment = paymentService.findById(payId);
            if (payment != null) {
                commonResponse.setCode(200);
                commonResponse.setMessage("查询成功, 端口号: " + serverPort);
                commonResponse.setData(payment);
            } else {
                commonResponse.setCode(404);
                commonResponse.setMessage("查询失败,ID为" + payId + "的数据不存在, 端口号: " + serverPort);
            }
        } else {
            commonResponse.setCode(501);
            commonResponse.setMessage("参数错误, 端口号: " + serverPort);
        }
        return commonResponse;
    }

    @GetMapping(value = "/getError/{payId}")
    public CommonResponse<Payment> findByIdError(@PathVariable("payId") Long payId) {
        CommonResponse<Payment> commonResponse = new CommonResponse<>();
        int a = 10 / 0;
        return commonResponse;
    }

    /**
     * 服务发现 discovery
     *
     * @return
     */
    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> System.out.println("******service****** " + service));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(System.out::println);
        return discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    /**
     * Feign80调用超时测试方法
     *
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


    /**
     * zipkin 链路监控
     *
     * @return
     */
    @GetMapping(value = "/zipkin")
    public String paymentZipkin() {
        return "hi, i am payment zipkin server fall back, welcome to guiGu, HA.";
    }

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
