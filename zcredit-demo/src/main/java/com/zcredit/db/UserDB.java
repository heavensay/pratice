package com.zcredit.db;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcredit.dto.UserInfo;

@Repository("userDB")
public class UserDB {
	
	public List<UserInfo> userList = UserDBInit.getUserList();
	
	/**
	 * @param id
	 * @param loginname
	 * @param sortId true:按id排序,false：按loginname排序
	 * @param asc true:升序,false:降序
	 * @return
	 */
	public List getUser(Long id,String loginname,Boolean sortId,Boolean asc){
		
		List<UserInfo> matchList = new ArrayList<UserInfo>();
		
		for (UserInfo userInfo : userList) {
			
			if(id == null && loginname == null){
				matchList.add(userInfo);
			}else if(id != null && userInfo.getId() == id){
				matchList.add(userInfo);
			}else if(userInfo.getLoginname().equals(loginname)){
				matchList.add(userInfo);
			}
		}
		
		if(sortId){
			return sortById(matchList,asc);
		}else{
			return sortByLoginname(matchList,asc);
		}
	}

	/**
	 * 按学生号排序
	 * @param userList
	 * @return
	 */
	public List<UserInfo> sortById(List<UserInfo> userList,final boolean asc){
		
		userList.sort(new Comparator<UserInfo>() {
			@Override
			public int compare(UserInfo user1, UserInfo user2) {
				int rank = 0;
				if(user1.getId()>user2.getId()){
					rank = 1;
				}else if (user1.getId()==user2.getId()){
					rank = 0;
				}else{
					rank = 1;
				}
				
				if(!asc){
					rank = -rank;
				}
				
				return rank;
			}
		});
		return userList;
	}
	
	/**
	 * 按登录名排列
	 * @param userList
	 * @return
	 */
	public List<UserInfo> sortByLoginname(List<UserInfo> userList,final boolean asc){
		
		userList.sort(new Comparator<UserInfo>() {
			@Override
			public int compare(UserInfo user1, UserInfo user2) {
				int rank = user1.getLoginname().compareToIgnoreCase(user2.getLoginname());
				if(!asc){
					rank = -rank;
				}
				
				return rank;
			}
		});
		return userList;
	}
}







