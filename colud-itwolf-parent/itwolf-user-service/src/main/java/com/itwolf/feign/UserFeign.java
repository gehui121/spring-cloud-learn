package com.itwolf.feign;

import com.itwolf.api.service.user.IUserService;
import com.itwolf.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/12/15 14:59.
 **/
@FeignClient(value = "data-service",fallback = UserFallback.class)
public interface UserFeign extends IUserService {
}
