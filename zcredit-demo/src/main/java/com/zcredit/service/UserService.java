package com.zcredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcredit.db.UserDB;

@Service
public class UserService {

	@Autowired
	UserDB userDB;
	
	public List getUser(Long id,String loginname,Boolean sortId,Boolean asc){
		return userDB.getUser(id, loginname, sortId, asc); 
	}
	
}
