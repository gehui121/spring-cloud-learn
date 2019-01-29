package com.mayikt.weixin.mp.handler;


import com.mayikt.constant.Constants;
import com.mayikt.core.utils.RedisUtils;
import com.mayikt.weixin.mp.builder.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.mayikt.core.utils.RegexUtils;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {
    //获取配置文件中消息提醒内容
    @Value("${mayikt.weixin.registion.code.message}")
    private String registionMessage;
    @Value("${mayikt.weixin.default.registion.code.message}")
    private String defaultMessage;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        //1.获取客户端传入的消息内容
        String fromContent = wxMessage.getContent();
        //2.根据正则表达式验证手机号码
        boolean flag = RegexUtils.checkMobile(fromContent);
        if (flag) {
            //3.生成4位验证码
            int registCode = registoCode();
            String content = registionMessage.format(registionMessage, registCode);
            //4.将注册码存放在redis中,手机号作为key，注册码为value,失效时间为30分钟
            redisUtils.set(Constants.WEIXINCODE_KEY+fromContent,registCode,Constants.WEIXINCODE_TIME_OUT);
            return new TextBuilder().build(content, wxMessage, weixinService);
        }
        String content = defaultMessage;
        return new TextBuilder().build(content, wxMessage, weixinService);
    }

    //随机生成4为验证码
    public int registoCode() {
        return (int) (Math.random() * 9000 + 1000);
    }
}
