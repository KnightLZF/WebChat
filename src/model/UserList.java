package model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	//用来存放所有的用户
	private List<User> list=new ArrayList();
	
	public UserList(){
		
	}
	
	//把用户加入到登录用户列表
	public void AddUser(User u){
		list.add(u);
	}
	
	//用户退出，把用户移除登录列表
	public void RemoveUser(User u){
		list.remove(u);
	}
	
	//判断用户u是否在当前的用户列表中
	public boolean JudgeUser(User u){
		String s=u.getusername();
		for(int i=0;i<list.size();i++){
			User user=(User)list.get(i);
			String s2=user.getusername();
			if(s.equals(s2)){
				return true;
			}
		}
		return false;
	}
}
