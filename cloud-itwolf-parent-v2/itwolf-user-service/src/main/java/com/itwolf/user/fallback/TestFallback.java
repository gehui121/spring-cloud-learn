package com.itwolf.user.fallback;

import com.itwolf.user.feign.TestFeign;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/23 18:54.
 **/
@Component
public class TestFallback implements TestFeign {
    @Override
    public String test() {
        return "服务器忙，请稍后重试";
    }
}
