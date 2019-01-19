package com.mayikt.weixin.service;

import com.mayikt.weixin.entity.APPEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName WeiXinService
 * @Description 提供微信公共服务接口
 * @Author Administrator
 * @Date 2019/1/19 14:36
 * @Version 1.0
 **/
@Api(tags = "微信服务接口")
public interface WeiXinService {
    /**
    *@Description 获取App信息
    *@Date 14:41 2019/1/19
    *@Param []
    *@Return APPEntity
    **/
    @ApiOperation("获取微信服务App信息")
    @GetMapping(value = "/getWeiXinApp")
    APPEntity getApp();
}
