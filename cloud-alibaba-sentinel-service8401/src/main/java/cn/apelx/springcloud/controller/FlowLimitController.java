package cn.apelx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 流控 Controller
 *
 * @author lx
 * @since 2020/7/8 15:54
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
       /* try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName() + "\t" + "testA...");
        return "------ testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "------ testB";
    }

    @GetMapping(value = "/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "-------- testD";
    }

    @GetMapping(value = "/testE")
    public String testE() {
        int a = 10 / 0;
        log.info("testE 测试异常比例");
        return "-------- testE";
    }

    @GetMapping("/testF")
    public String testF() {
        log.info("testF 测试异常数");
        int age = 10 / 0;
        return "-------- testF";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10/0;
        return " --------- testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException blockException) {
        return "--------- deal testHotKey, /(ㄒoㄒ)/~~";
    }
}
