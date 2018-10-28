package com.gehui.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/23 19:15.
 **/
@FeignClient(name = "eureka-service") //@FeignClient 调用服务接口，name是服务名称
public interface HelloApiFeign {

    //Feign客户端以springmvc接口方式书写 @RequestMapping是调用远程的匹配路径
    @RequestMapping(value = "/hello/{name}")
    //服务接口
    public String hello(@PathVariable(value = "name") String name);
}
