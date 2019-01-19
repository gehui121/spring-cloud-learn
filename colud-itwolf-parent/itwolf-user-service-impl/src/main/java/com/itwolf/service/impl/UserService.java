package com.itwolf.service.impl;

import com.itwolf.feign.UserFeign;
import com.itwolf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2018/12/15 14:47.
 **/
@Component
public class UserService implements IUserService {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getDefaultUser() {
        return userFeign.getDefaultUser();
    }

    @Override
    public String getContextUserId() {
        return userFeign.getContextUserId();
    }

    @Override
    public List<String> getProviderData() {
//        String url = "http://data-service/getProviderData";
//        List list = (List<String>) restTemplate.getForObject(url,List.class);
        return null;
    }
}
