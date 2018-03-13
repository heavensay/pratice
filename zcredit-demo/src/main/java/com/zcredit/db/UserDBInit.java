package com.zcredit.db;

import java.util.ArrayList;

import com.zcredit.dto.UserInfo;

public class UserDBInit {

	private static ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
	
	static{
		initDB();
	}
	
	public static ArrayList<UserInfo> initDB(){
		
		UserInfo user1 = new UserInfo(1,"andy",null,"Andy");
		UserInfo user2 = new UserInfo(2,"carl",null,"Carl");
		UserInfo user3 = new UserInfo(3,"bruce",null,"Bruce");
		UserInfo user4 = new UserInfo(4,"dolly",null,"Dolly");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		return userList;
		
	}
	
	public static ArrayList<UserInfo> getUserList(){
		return  userList;
	}
	
}
