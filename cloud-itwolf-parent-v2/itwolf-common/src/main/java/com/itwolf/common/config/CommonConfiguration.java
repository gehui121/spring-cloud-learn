package com.itwolf.common.config;

import com.itwolf.common.intercepter.FeignUserContextInterceptor;
import com.itwolf.common.intercepter.RestTemplateUserContextInterceptor;
import com.itwolf.common.intercepter.UserContextInterceptor;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@EnableWebMvc
public class CommonConfiguration implements WebMvcConfigurer {
	
	/**
	 * 请求拦截器
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserContextInterceptor());
    }
	
	/***
	 * RestTemplate 拦截器，在发送请求前设置鉴权的用户上下文信息
	 * @return
	 */
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateUserContextInterceptor());
        return restTemplate;
    }


	/**
	 * 创建Feign请求拦截器，在发送请求前设置认证的用户上下文信息
	 */
	@Bean
	@ConditionalOnClass(Feign.class)
	public FeignUserContextInterceptor feignTokenInterceptor() {
		return new FeignUserContextInterceptor();
	}
   
}
