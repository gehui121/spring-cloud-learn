package com.itwolf.data.controller;

import com.itwolf.api.service.user.IUserService;
import com.itwolf.common.context.UserContextHolder;
import com.itwolf.data.config.DataConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/15 15:27.
 **/
@RestController
@RefreshScope
public class UserDataController implements IUserService {

    @Autowired
    private DataConfig dataConfig;

    /**
     * 获取配置文件中系统默认用户
     * @return
     */
    @Override
    @GetMapping("/getDefaultUser")
    public String getDefaultUser() {
        return dataConfig.getDefaultUser();
    }

    /**
     * 获取上下文用户
     * @return
     */
    @Override
    @GetMapping("/getContextUserId")
    public String getContextUserId() {
        String contextUserId = UserContextHolder.currentUser().getUserId();
        return contextUserId;
    }

    /**
     * 获取供应商数据
     * @return
     */
    @Override
    @GetMapping("/getProviderData")
    public List<String> getProviderData() {
        List<String> provider = new ArrayList<String>();
        provider.add("Beijing Company");
        provider.add("Shanghai Company");
        provider.add("Shenzhen Company");
        return provider;
    }
}
