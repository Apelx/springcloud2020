package cn.apelx.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Component;

/**
 * 限流服务接口
 *
 * @author apelx
 * @since 2022-04-27
 */
@Component
public class FlowLimitService {

    @SentinelResource(value = "/testCC")
    public String testCC() {
        return "-----------test C";
    }
}
