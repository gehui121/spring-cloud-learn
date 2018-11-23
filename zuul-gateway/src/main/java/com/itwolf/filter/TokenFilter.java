package com.itwolf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/11/20 20:58.
 * //网关过滤器
 **/
public class TokenFilter extends ZuulFilter {
    //过滤器类型，pre表示在请求之前执行，
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，当一个请求在同一个阶段时存在多个过滤器，多个过滤器执行顺序问题，
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器拦截业务逻辑代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //案例：拦截所有的服务接口，判断服务接口上是否有传递userToken参数
        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2.获取request
        HttpServletRequest request = currentContext.getRequest();
        //3.获取token，从请求头中获取
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)){
            //4.如果token为空，不会继续执行，不会调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("usertoken is null!");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //5.正确执行调用其他服务接口逻辑
        return null;
    }


}
