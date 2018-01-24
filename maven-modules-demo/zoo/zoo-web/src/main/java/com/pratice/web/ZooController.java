package com.pratice.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pratice.server.ZooServer;


/**
 * 
 * 
 */
@Controller
@RequestMapping("/zoo")
public class ZooController{

	/**
	 * @return
	 */
	@RequestMapping(value = "/getZoo",method=RequestMethod.GET)
	@ResponseBody
	public String getUserinfo(){

		ZooServer zooServer = new ZooServer();
		return zooServer.getZoo();
	}
	
}
