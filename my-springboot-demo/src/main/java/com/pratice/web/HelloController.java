package com.pratice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("hello")
public class HelloController {

    @Value("${custom.msg}")
    private String msg;

    @Value("${custom.num}")
    private Integer num;

    @RequestMapping("/say")
    @ResponseBody
    public String say(){
        return "hello world,"+msg+",num:"+num;
    }
}
