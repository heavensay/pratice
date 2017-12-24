package com.study.swagger.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * swagger文档自动生成测试
 * 
 * 
 */
@Api(value="swagger")
@Controller
@RequestMapping("/swagger")
public class SwaggerController{

	/**
	 * @return
	 */
	@RequestMapping(value = "/getUser",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="获取用户信息",httpMethod="GET",notes="get user by id",response=String.class)
	public String getUserinfo(String name,int age){

//		String.format("[{name:'jack',age:30}]", args)
		return "[{name:'jack',age:30}]";
	}
	
}
