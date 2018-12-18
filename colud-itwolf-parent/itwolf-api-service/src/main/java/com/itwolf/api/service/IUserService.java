package com.itwolf.api.service;

import com.itwolf.api.entity.UserEntity;
import com.itwolf.common.base.ResponseBase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/30 17:02.
 **/
public interface IUserService {
    /**
     * 验证服务雪崩,服务没延迟
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/getUserInfo/{name},{age}")
    public UserEntity getUserInfo(@PathVariable("name") String name, @PathVariable("age") Integer age);

    /**
     * 验证服务雪崩，服务延迟2秒
     * @return
     */
    @RequestMapping(value = "/orderToUserInfo")
    public String orderToUserInfo();

    @RequestMapping(value = "/testResponse")
    public ResponseBase testResponse();

}
