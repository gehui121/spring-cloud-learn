package com.itwolf.gateway.controller;

import com.itwolf.gateway.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/12/23 11:29.
 **/
@RestController
public class TokenController {
    @GetMapping(value = "/tokenInfo/{name}")
    public String getToken(@PathVariable(value = "name") String name){
        String token = JwtUtil.generateToken(name);
        return token;
    }
}
