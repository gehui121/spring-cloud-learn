package com.itwolf.feign;

import com.itwolf.api.service.IUserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/10/30 17:10.
 **/
@FeignClient("member-service")
public interface UserFeign extends IUserService {
}
