package com.itwolf.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/12/2 9:54.
 * 监听通道
 **/

public interface IReadMsg {

    //创建监听消息的通道
    @Input("my_stream_channel")
    SubscribableChannel sendMsg();
}
