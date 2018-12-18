package com.itwolf.common.interceptor;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/12/8 14:29.
 * Hystrix的缓存在一次请求内有效，这要求请求要在一个Hystrix上下文里，可以使用filter过滤器或者interceptor拦截器初始化，
 **/
public class CacheContextInterceptor implements HandlerInterceptor {

    HystrixRequestContext context = null;
    //初始化hystrix上下文context
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        context = HystrixRequestContext.initializeContext();
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    //关闭hystrix上下文
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        context.shutdown();
    }
}
