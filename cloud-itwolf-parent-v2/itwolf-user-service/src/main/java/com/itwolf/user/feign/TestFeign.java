package com.itwolf.user.feign;

import com.itwolf.user.fallback.TestFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/12/23 18:50.
 **/
@FeignClient(value = "data-service",fallback = TestFallback.class)
public interface TestFeign {

    @GetMapping(value = "/data/test")
    public String test();
}
