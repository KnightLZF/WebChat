package model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	//����������е��û�
	private List<User> list=new ArrayList();
	
	public UserList(){
		
	}
	
	//���û����뵽��¼�û��б�
	public void AddUser(User u){
		list.add(u);
	}
	
	//�û��˳������û��Ƴ���¼�б�
	public void RemoveUser(User u){
		list.remove(u);
	}
	
	//�ж��û�u�Ƿ��ڵ�ǰ���û��б���
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
