package com.itwolf.stream.listen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/1 15:18.
 **/
@Component
public class ReadMsgListen {

    @Value("${server.port}")
    private String serverPort;

    //接收消息通道的消息
    @StreamListener("my_stream_channel")
    public void redMsg(String msg){
        System.out.println("消费者消费到的消息是 ："+msg+ "端口号是："+serverPort);
    }
}
