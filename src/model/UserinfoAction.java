package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class UserinfoAction {
	
	List<Userinfo> list = new ArrayList<Userinfo>();

	private String username1;//当前要查找的好友对象
	
	public UserinfoAction(){
		
	}
	
	//设置当前用户名
	public void setUsername(String username1) {
		this.username1 = username1;
	}


	/*
	 * 查看某一好友的详细资料
	 */
	public List<Userinfo> SelectUsersInfo(){
	
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			String sql="select * from userinfo where username='"+username1+"';";
			ResultSet rs=null;
			Userinfo ui=new Userinfo();
			try{
				rs=con.executeQuery(sql);
				while(rs.next()){
					
					ui.setUsername(username1);
					ui.setSex(rs.getString("sex"));
					ui.setAge(rs.getInt("age"));
					list.add(ui);
			}
				con.closeResultSet(rs);
				con.closeConnection();
		}catch(SQLException e){e.printStackTrace();}
		}
		return list;
		
	}
}
