package com.mayikt;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ZuulApp
 * @Description 网关整合Swagger发布api服务文档，网关只是收集各个接口的文档统一展示，在各个服务中仍然需要集成swaggerAPI
 * @Author gehui
 * @Date 2019/1/19 17:58
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2Doc
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }

    //添加文档来源
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider{

        @Override
        public List<SwaggerResource> get() {
            /**app-mayikt-member服务别名，
             * 网关通过别名获取远程服务的swaggerAPI
             **/
            List resource = new ArrayList();
            resource.add(swaggerResource("app-mayikt-member","/app-mayikt-member/v2/api-docs","1.0"));
            resource.add(swaggerResource("app-mayikt-weixin","/app-mayikt-weixin/v2/api-docs","1.0"));
            return resource;
        }

        private Object swaggerResource(String name, String localtion, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(localtion);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}
