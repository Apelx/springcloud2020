package cn.apelx.springcloud.service;

/**
 * 消息生产者
 *
 * @author lx
 * @since 2020/7/1 20:46
 */
public interface IMessageProvider {
    /**
     * 发送消息
     *
     * @return
     */
    String send();
}
