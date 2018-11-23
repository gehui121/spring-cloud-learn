package com.itwolf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/11/22 14:53.
 * 网关过滤器
 **/
@Component
public class TokenFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Value("${server.port}")
    private String serverPort;


    //过滤器类型，Pre表示在请求之前执行
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器执行顺序，当同一个请求在同一阶段请求多个过滤器，解决过滤器执行顺序问题
    @Override
    public int filterOrder() {
        return 0;
    }

    //表示过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //编写过滤器拦截的业务的具体逻辑
    @Override
    public Object run() throws ZuulException {
        //案例：拦截所有服务接口，判断服务接口上是否有传递userToken参数
        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2.获取request请求头
        HttpServletRequest request = currentContext.getRequest();
        //3.从请求头中获取token
        String userToken = request.getParameter("userToken");
        if (StringUtils.isBlank(userToken)){
            //4.如果token为空，不会继续执行，不会调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.setResponseBody("userToken is null!");
            return null;
        }
        //5.如果不为空，正确调用其他服务接口逻辑
        logger.info("nginx轮训机制实网关服务器负载均衡，端口号是：................{}",serverPort);
        return null;
    }
}
