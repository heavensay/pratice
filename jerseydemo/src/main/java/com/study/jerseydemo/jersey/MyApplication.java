package com.study.jerseydemo.jersey;

import com.study.jerseydemo.service.UserService;
import com.study.jerseydemo.web.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {
  
    /** 
     * Register JAX-RS application components. 
     */  
    public MyApplication () {  
          
      //自己写的服务
//      register(UserController.class);

//          //用 Jackson JSON 的提供者来解释 JSON
//          register(JacksonFeature.class);
        packages("com.study.jerseydemo.web");
          
      //Spring filter 提供了 JAX-RS 和 Spring 请求属性之间的桥梁
      register(RequestContextFilter.class);
    }  
}  