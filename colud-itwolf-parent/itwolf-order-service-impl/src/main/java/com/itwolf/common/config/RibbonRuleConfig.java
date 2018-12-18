package com.itwolf.common.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/12/3 10:12.
 * 这个配置为全局配置负载均衡策略方式，
 * 可以单独针对某一个资源通过注解设置其特有的策略或者使用配置文件 <client name>.ribbon.*
 * @RibbonClient
 **/
@Configuration
public class RibbonRuleConfig {

    //测试完注释掉，使用默认的轮训机制
//    @Bean
//    public IRule ribbonRule(){
//        //全局设置负载均衡策略为随机策略
//        return new RandomRule();
//    }
}
