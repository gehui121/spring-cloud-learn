package com.itwolf.api.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Administrator on 2018/10/27 9:45.
 **/
@FeignClient("hello-provider-feign")
public interface RefactorUserService extends IUserService{
}
