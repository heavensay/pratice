package com.pratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/shop")
public class ShopController {

	@RequestMapping("/getShop")
	@ResponseBody
	public String getShop(String name){
		return "welcome to animate shop ,"+name;
	}
	
}
