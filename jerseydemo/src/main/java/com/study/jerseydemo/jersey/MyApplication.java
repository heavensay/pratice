package com.study.jerseydemo.jersey;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.study.jerseydemo.web.UserController;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication() {

        //自己写的服务
//        register(UserController.class);
        packages("com.study.jerseydemo");

        // 支持json格式数据解析
        register(JacksonFeature.class);
        register(JacksonJaxbJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);

        //Spring filter 提供了 JAX-RS 和 Spring 请求属性之间的桥梁
        register(RequestContextFilter.class);
    }
}  