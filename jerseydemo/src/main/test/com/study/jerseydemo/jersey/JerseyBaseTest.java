package com.study.jerseydemo.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Application;

public class JerseyBaseTest extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        ResourceConfig rc = new ResourceConfig().packages("com.study.jerseydemo");
        rc.register(RequestContextListener.class);

        //不配置也生效
//        rc.register(SpringLifecycleListener.class);
//        rc.property("contextConfigLocation", "classpath:spring/spring-config.xml");
        return rc;
    }
}
