package com.mayikt.member.service;

import com.mayikt.weixin.entity.APPEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName MemberService
 * @Description 会员服务
 * @Author gehui
 * @Date 2019/1/19 15:49
 * @Version 1.0
 **/
public interface MemberService {
    /**
    *@Description 会员调用微信
    *@Date 15:53 2019/1/19
    *@Param []
    *@Return com.mayikt.weixin.entity.APPEntity
    **/
    @GetMapping(value = "/memberToWeiXin")
    APPEntity memberToWeiXin();
}
