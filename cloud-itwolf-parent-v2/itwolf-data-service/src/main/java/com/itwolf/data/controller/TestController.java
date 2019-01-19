package com.itwolf.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itwolf.common.context.UserContextHolder;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/12/23 14:52.
 **/
@RestController
public class TestController {
    @GetMapping(value = "/data/test")
    public String test(HttpServletRequest request){
        System.out.println("auth success, the user is : " + UserContextHolder.currentUser().getUserName());
        System.out.println("----------------success access data service----------------");
        return "success access provider service!";
    }
}
