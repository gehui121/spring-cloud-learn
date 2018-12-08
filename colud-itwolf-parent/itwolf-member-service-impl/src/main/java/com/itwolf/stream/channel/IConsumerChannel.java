package com.itwolf.stream.channel;

import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/12/2 16:02.
 **/
public interface IConsumerChannel {


    //创建监听消息的通道
//    @Input("my_money_channel")
    SubscribableChannel readMsg();
}
