package com.gehui;

import com.gehui.HelloApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/24 12:56.
 **/
@RestController
public class FeignController {

    @Autowired
    private HelloApiFeign helloApiFeign;

    @RequestMapping(value = "/customer/hello/{name}")
    public String hello(@PathVariable String name){
        String response = helloApiFeign.hello(name);
        return response;
    }

    @RequestMapping(value = "/customer/hello1")
    public String hello1(){
        String response = helloApiFeign.hello1();
        return response;
    }
}
