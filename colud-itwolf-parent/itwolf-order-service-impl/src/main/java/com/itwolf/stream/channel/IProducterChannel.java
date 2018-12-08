package com.itwolf.stream.channel;

import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/12/2 14:57.
 **/
//创建生产者消息通道
public interface IProducterChannel {

//    @Output("my_money_channel")
    SubscribableChannel sendMsg();
}
