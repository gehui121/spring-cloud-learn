package com.mayikt.member.feign;/**
 * Created by Administrator on 2019/1/19 16:02.
 **/

import com.mayikt.weixin.service.WeiXinService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *@ClassName WeiXinServiceFeign
 *@Description
 *@Author Administrator
 *@Date 2019/1/19 16:02
 *@Version 1.0
 **/
@FeignClient("app-mayikt-weixin")
public interface WeiXinServiceFeign extends WeiXinService {
//    /**
//     *@Description 获取App信息
//     *@Date 14:41 2019/1/19
//     *@Param []
//     *@Return APPEntity
//     **/
//    @GetMapping(value = "/getWeiXinApp")
//    APPEntity getApp();
}
