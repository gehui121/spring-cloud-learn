package com.itwolf.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/12/1 11:56.
 * 创建发送消息的通道
 **/

public interface ISendMessage {
    //1.创建发送消息的通道，
    @Output("my_stream_channel")
    SubscribableChannel sendMsg();
}
