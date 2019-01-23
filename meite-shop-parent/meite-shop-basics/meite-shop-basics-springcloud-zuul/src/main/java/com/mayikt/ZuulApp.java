package com.mayikt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
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
@EnableApolloConfig
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }

    //添加文档来源
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {

        @ApolloConfig//获取apollo配置文件实例，动态获取文档
        private Config config;

        /**
         * @Description 每次刷新swagger-ui.html都会执行这个方法，加载文档
         * @Date 22:49 2019/1/23
         * @Param []
         * @Return java.util.List<springfox.documentation.swagger.web.SwaggerResource>
         **/
        @Override
        public List<SwaggerResource> get() {
            /**app-mayikt-member服务别名，
             * 网关通过别名获取远程服务的swaggerAPI
             **/
//            List resource = new ArrayList();
//            resource.add(swaggerResource("app-mayikt-member", "/app-mayikt-member/v2/api-docs", "1.0"));
//            resource.add(swaggerResource("app-mayikt-weixin", "/app-mayikt-weixin/v2/api-docs", "1.0"));
            return resources();
        }

        /**
         * @Description 创建SwaggerResource对象
         * @Date 23:07 2019/1/23
         * @Param [name, localtion, version]
         * @Return java.lang.Object
         **/
        private Object swaggerResource(String name, String localtion, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(localtion);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }

        /**
         * @Description 从阿波罗服务器获取swaggerDocument配置
         * @Date 22:56 2019/1/23
         * @Param []
         * @Return java.lang.String
         **/
        private String swaggerDocument() {
            //第二个""表示没有获取到指定默认的参数
            String property = config.getProperty("mayikt.zuul.swaggerDocument", "[]");
            return property;
        }

        /**
         * @Description 解析获取到的配置，动态添加文档
         * @Date 23:06 2019/1/23
         * @Param []
         * @Return java.util.List<springfox.documentation.swagger.web.SwaggerResource>
         **/
        private List<SwaggerResource> resources() {
            List resource = new ArrayList();
            String swaggerDocJson = swaggerDocument();
            JSONArray jsonArray = JSONArray.parseArray(swaggerDocJson);
            for (int i = 0; i < jsonArray.size(); i++) {
                String name = ((JSONObject) jsonArray.get(i)).getString("name");
                String localtion = ((JSONObject) jsonArray.get(i)).getString("location");
                String version = ((JSONObject) jsonArray.get(i)).getString("version");
                resource.add(swaggerResource(name, localtion, version));
            }
            return resource;
        }
    }
}
