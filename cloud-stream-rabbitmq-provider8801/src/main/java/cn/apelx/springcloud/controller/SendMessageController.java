package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息发送Controller
 *
 * @author lx
 * @since 2020/7/1 20:57
 */
@RestController
public class SendMessageController {

    private IMessageProvider messageProvider;

    @GetMapping(value = "sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

    @Autowired
    public void setMessageProvider(IMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
