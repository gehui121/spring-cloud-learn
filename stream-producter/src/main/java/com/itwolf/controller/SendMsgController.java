package com.itwolf.controller;

import com.itwolf.stream.ISendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Administrator on 2018/12/1 12:00.
 **/
@RestController
public class SendMsgController {

    @Autowired
    private ISendMessage sendMessage;

    //生产者使用通道投递消息
    @RequestMapping("sendMsg")
    public String sendMsg(){
        String msg = UUID.randomUUID().toString();
        System.out.println("生产者发送的消息内容是：" +msg);
        Message build = MessageBuilder.withPayload(msg.getBytes()).build();
        boolean flag = sendMessage.sendMsg().send(build);
        return "success";
    }
}
