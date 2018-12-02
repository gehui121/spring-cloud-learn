package com.itwolf;

import com.itwolf.stream.ISendMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by Administrator on 2018/12/1 11:28.
 * 默认以通道名称创建交换机，消费者在启动的时候随机创建一个队列名称
 **/
@SpringBootApplication
@EnableBinding(ISendMessage.class)
public class StreamProductorApp {
    public static void main(String[] args) {
        SpringApplication.run(StreamProductorApp.class);
    }
}
