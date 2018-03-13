package com.zcredit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcredit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(params = { "method=queryUser" })
	@ResponseBody
	public List queryUser(Long id,String loginname,String sort,String order){
		Boolean sortId = true;
		Boolean asc = true;
		
		if(sort != null && sort.equals("loginname")) sortId = false;
		
		if(order != null && order.equals("desc")) asc = false;
		
		if(loginname != null && "".equals(loginname)) loginname = null;
		
		return userService.getUser(id, loginname, sortId, asc); 
	}

}
