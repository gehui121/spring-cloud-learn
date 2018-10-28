package com.itwolf.api.feign.impl;

import com.itwolf.api.entity.UserEntity;
import com.itwolf.api.feign.RefactorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/27 9:48.
 **/
@RestController
public class RefactorUserController implements RefactorUserService {

    @Autowired
    private RefactorUserService refactorUserService;


    @RequestMapping(value = "/getuser/{name}")
    @Override
    public UserEntity getUser(@PathVariable String name) {
        UserEntity response = refactorUserService.getUser(name);
        return response;
    }

    @RequestMapping(value = "/getUserByNameAndAge/{name},{age}")
    @Override
    public UserEntity getUserByNameAndAge(@PathVariable String name, @PathVariable Integer age) {
        UserEntity response = refactorUserService.getUserByNameAndAge(name, age);
        return response;
    }
}
