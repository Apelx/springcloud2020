package cn.apelx.springcloud.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 雪花算法分布式ID生成器
 *
 * @author lx
 * @since 2020/7/11 16:10
 */
@Component
@Slf4j
public class IdGeneratorSnowFlakeUtil {

    private long defaultWorkerId = 0L;
    private long defaultDataCenterId = 0L;

    private Snowflake snowflake = IdUtil.createSnowflake(defaultWorkerId, defaultDataCenterId);

    @PostConstruct
    public void init() {
        try {
            defaultWorkerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("current machine worker id: {}", defaultWorkerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("current machine worker id get fail.", ex);
            defaultWorkerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    /**
     * 获取雪花算法分布式ID
     *
     * @return
     */
    public synchronized long snowFlakeId() {
        return snowflake.nextId();
    }

    /**
     * 获取雪花算法分布式ID
     *
     * @param workerId
     * @param dataCenterId
     * @return
     */
    public synchronized long snowFlakeId(long workerId, long dataCenterId) {
        return IdUtil.createSnowflake(workerId, dataCenterId).nextId();
    }

   /* public static void main(String[] args) {
        IdGeneratorSnowFlakeUtil util = new IdGeneratorSnowFlakeUtil();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> System.out.println(util.snowFlakeId()));
        }
        threadPool.shutdown();
    }*/
}
