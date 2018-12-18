package com.itwolf.api.service.user;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/12/15 14:54.
 **/
public interface IUserService {

    //获取配置文件中系统默认用户
    @GetMapping(value = "/getDefaultUser")
    public String getDefaultUser();

    /**
     * 获取上下文用户
     * @return
     */
    @GetMapping(value = "/getContextUserId")
    public String getContextUserId();

    /**
     * 获取供应商数据
     * @return
     */
    @GetMapping(value = "/getProviderData")
    public List<String> getProviderData();
}
