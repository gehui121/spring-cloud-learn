package com.itwolf.stream.producter;

import com.itwolf.stream.channel.IProducterChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/2 15:02.
 **/
@RestController
public class SendMsgProducter {

    @Autowired
    private IProducterChannel sendMsg;

    @RequestMapping(value = "/changeMOneySendMsg/{money}")
    public String sendMsg(@PathVariable Integer money) {
        String msg = "变动金额为 ：" + money;
        System.out.println("订单系统生产消息是：" + msg );
        //生产者使用通道投递消息
        Message build = MessageBuilder.withPayload(msg.getBytes()).build();
        sendMsg.sendMsg().send(build);
        return "success";
    }
}
