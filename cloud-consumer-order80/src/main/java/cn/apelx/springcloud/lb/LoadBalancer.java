package cn.apelx.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义 负载均衡接口
 *
 * @author lx
 * @since 2020-6-6
 */
public interface LoadBalancer {

    /**
     * 获取调用的服务
     *
     * @param serviceInstances 可用的服务实例列表
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
