package com.zcredit.db;

import java.util.List;

import org.junit.Test;

import com.zcredit.dto.UserInfo;

public class UserDBTest {

	@Test
	public void getUserTest(){
		UserDB db = new UserDB();
		List<UserInfo> list = db.getUser(null, null,true,true);
		for (UserInfo user : list) {
			System.out.println("id:"+user.getId()+",loginname:"+user.getLoginname());
		}
		
		
	}
	
	@Test
	public void reverseTest(){
		int a = 0;
		int b = 1;
		int c = -2;
		System.out.println(-a);
		System.out.println(-b);
		System.out.println(-c);
		
	}
	
}
