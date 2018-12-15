package com.itwolf;

import com.itwolf.stream.channel.IConsumerChannel;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/10/30 16:49.
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@Api("会员服务")
@EnableBinding(IConsumerChannel.class)
@EnableHystrix
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class);
    }
}
