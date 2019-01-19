package com.mayikt.member.service;

import com.mayikt.weixin.entity.APPEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName MemberService
 * @Description 会员服务
 * @Author gehui
 * @Date 2019/1/19 15:49
 * @Version 1.0
 **/
@Api(tags = "会员服务接口")
public interface MemberService {
    /**
    *@Description 会员调用微信
    *@Date 15:53 2019/1/19
    *@Param []
    *@Return com.mayikt.weixin.entity.APPEntity
    **/
    @ApiOperation(value = "会员服务调用微信服务")
    @GetMapping(value = "/memberToWeiXin")
    APPEntity memberToWeiXin();
}
