package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.service.IMessageProvider;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * 消息生产者
 *
 * @author lx
 * @since 2020/7/1 20:47
 */
@EnableBinding(Source.class) // 定义消息推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    private MessageChannel output;

    /**
     * 发送消息
     *
     * @return
     */
    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("********serial: " + serial);
        return serial;
    }

    @Autowired
    public void setMessageChannel(MessageChannel output) {
        this.output = output;
    }
}
