package com.mayikt.weixin.service;

import com.mayikt.weixin.entity.APPEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName WeiXinService
 * @Description 提供微信公共服务接口
 * @Author Administrator
 * @Date 2019/1/19 14:36
 * @Version 1.0
 **/

public interface WeiXinService {
    /**
    *@Description 获取App信息
    *@Date 14:41 2019/1/19
    *@Param []
    *@Return APPEntity
    **/
    @GetMapping(value = "/getWeiXinApp")
    APPEntity getApp();
}
