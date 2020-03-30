package com.tech4flag.springcloud.service.impl;

import com.tech4flag.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;
/**
 * @author ltf
 * @date 2020/3/27 11:20
 */
//这不是传统的service,这是和rabbitmq打交道的，不需要加注解@Service
//这里不掉dao，掉消息中间件的service
//信道channel和exchange绑定在一起
@EnableBinding(Source.class)//定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        //发送信息
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("我是消息生产者： "+"serial = " + serial);
        return null;
    }
}