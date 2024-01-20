package cn.apelx.springcloud.config;

import feign.Logger;
import feign.micrometer.MicrometerCapability;
import feign.micrometer.MicrometerObservationCapability;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign日志配置类
 *
 * @author lx
 * @since 2020/6/6 17:52
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        /**
         * NONE: 默认的，不显示任何日志
         *
         * BASIC: 仅记录请求方法、URL、响应状态码及执行时间
         *
         * HEADERS: 除了BASIC中定义的信息之外，还有请求和响应的头信息
         *
         * FULL: 除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
         */
        return Logger.Level.FULL;
    }

    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnBean(type = ["io.micrometer.observation.ObservationRegistry"])
    public MicrometerObservationCapability micrometerObservationCapability(ObservationRegistry registry) {
        return new MicrometerObservationCapability(registry);
    }

    @Bean
//    @ConditionalOnBean(type = ["io.micrometer.core.instrument.MeterRegistry"])
//    @ConditionalOnMissingBean(
//            MicrometerCapability::class,
//            MicrometerObservationCapability::class
//    )
    public MicrometerCapability micrometerCapability(MeterRegistry registry ) {
        return new MicrometerCapability(registry);
    }
}
