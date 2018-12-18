package com.itwolf.fallback;

import com.itwolf.feign.UserFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/15 14:59.
 **/
@Component
public class UserFallback implements UserFeign {
    @Override
    public String getDefaultUser() {
        return new String("get getDefaultUser failed");
    }

    @Override
    public String getContextUserId() {
        return new String("get getContextUserId failed");
    }

    @Override
    public List<String> getProviderData() {
        List<String> list = new ArrayList<>();
        list.add("这个使用的是restTemplate调用，");
        return list;
    }
}
