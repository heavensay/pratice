package com.study.swagger.spring;  
  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
  
@Configuration
@EnableSwagger2
@EnableWebMvc
//@ComponentScan(basePackages ="com.myhexin.web")
public class Swagger2Config {
  

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.myhexin.web"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
	}
	
    private ApiInfo apiInfo()  
    {  
        return new ApiInfoBuilder()  
                .title("SpringMVC中使用Swagger2构建RESTful API文檔")  
                .termsOfServiceUrl("service url")  
                .contact("ljy")  
                .version("1.1.1")  
                .build();
    }  
	
}  