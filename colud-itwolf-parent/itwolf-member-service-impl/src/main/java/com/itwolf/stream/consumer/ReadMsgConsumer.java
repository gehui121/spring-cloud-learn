package com.itwolf.stream.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/2 16:06.
 **/
@Component
public class ReadMsgConsumer {

    @Value("${server.port}")
    private String serverPort;

    //接收消息通道的消息
//    @StreamListener("my_money_channel")
    public void readMsg(String msg){
        System.out.println("会员系统消费到的消息是 ："+msg+ "端口号是："+serverPort);
    }
}
