package com.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class MySpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringbootDemoApplication.class, args);
	}
	
    @RequestMapping("/home")
    @ResponseBody
	public String home(){
		return "hello world";
	}
}


