package com.itwolf.user.controller;

import com.itwolf.user.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018/12/23 15:00.
 **/
@RestController
public class TestController {

    @Autowired
    private TestFeign testFeign;

    @RequestMapping("/user/test")
    public String test(HttpServletRequest request) {
        System.out.println("----------------success access test method!----------------");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        return "success access test method!!";
    }

    @RequestMapping("/user-data/test")
    public String accessdata(HttpServletRequest request) {
        String result = testFeign.test();
        return result;
    }
}
