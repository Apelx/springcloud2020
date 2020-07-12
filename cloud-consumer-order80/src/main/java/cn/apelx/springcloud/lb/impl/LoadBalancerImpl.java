package cn.apelx.springcloud.lb.impl;

import cn.apelx.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定负载均衡实现类
 *
 * @author lx
 * @since 2020/6/6 11:45
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取访问次数（自增）
     * 自旋锁 + 原子整型类
     *
     * @return
     */
    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("**********第" + next + "次访问********");
        return next;
    }

    /**
     * 获取调用的服务
     *
     * @param serviceInstances 可用的服务实例列表
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        if (serviceInstances != null && !serviceInstances.isEmpty()) {
            return serviceInstances.get(getAndIncrement() % serviceInstances.size());
        }
        return null;
    }
}
