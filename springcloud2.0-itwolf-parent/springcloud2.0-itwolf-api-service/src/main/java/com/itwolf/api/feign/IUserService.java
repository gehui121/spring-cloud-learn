package com.itwolf.api.feign;

import com.itwolf.api.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/27 9:33.
 **/
public interface IUserService {

    @RequestMapping(value = "/user/{name}")
    public UserEntity getUser(@PathVariable(value = "name") String name);

    /**
     * 多参绑定
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/getUserByNameAndAge/{name},{age}")
    public UserEntity getUserByNameAndAge(@PathVariable(value = "name") String name,@PathVariable(value = "age") Integer age);
}
