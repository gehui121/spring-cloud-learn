package com.itwolf;

import com.itwolf.stream.channel.IReadMsg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by Administrator on 2018/12/1 15:11.
 **/
@SpringBootApplication
@EnableBinding(IReadMsg.class)//绑定监听器
public class StreamConsumer {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer.class);
    }
}
