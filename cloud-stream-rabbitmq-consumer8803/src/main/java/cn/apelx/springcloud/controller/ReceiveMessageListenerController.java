package cn.apelx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 接收消息监听器控制器
 *
 * @author lx
 * @since 2020/7/1 21:52
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 接收消息
     *
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.err.println("消费者2号，————> 接收到的消息：" + message.getPayload() + "\t port: " + serverPort
                + " -----> header: " + message.getHeaders().toString());
    }
}
