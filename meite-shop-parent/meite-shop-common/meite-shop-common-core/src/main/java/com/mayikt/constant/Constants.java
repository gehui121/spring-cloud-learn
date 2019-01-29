package com.mayikt.constant;/**
 * Created by Administrator on 2019/1/27 18:04.
 **/

/**
 *@ClassName Constants  常量
 *@Description
 *@Author Administrator
 *@Date 2019/1/27 18:04
 *@Version 1.0
 **/
public interface Constants {

    //响应请求成功
    String HTTP_RES_CODE_200_VALUE = "success";
    //系统错误
    String HTTP_RES_CODE_500_VALUE ="fial";
    //响应请求成功code
    Integer HTTP_RES_CODE_200 =200;
    //系统错误码
    Integer HTTP_RES_CODE_500=500;
    //未关联QQ账号
    Integer HTTP_RES_CODE_201 = 201;
    //发送邮件
    String MESSAGE_EMAIL = "email";
    //会员token
    String TOKEN_MEMBER = "TOKEN_MEMBER";
    //用户有效期90天
    Long TOKEN_MEMBER_TIME = (long)(60*60*24*90);
    int COOKIE_TOKEN_MEMBER_TIME = (60*60*24*90);
    //cookie会员token名称
    String COOKIE_MEMBER_TOKEN = "coolie_member_token";
    //微信注册码
    String WEIXINCODE_KEY = "weixin.code";
    //微信注册码有效期30分钟
    Long WEIXINCODE_TIME_OUT = 1800L;
}
