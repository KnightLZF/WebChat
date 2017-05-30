package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class UserAction {

	List<User> list = new ArrayList<User>();
	/*
	 * 查询所有注册过的用户
	 */
	public List<User> SelectAll(){
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			String sql="select * from user";
			ResultSet rs=null;

			try{
				rs=con.executeQuery(sql);
				while(rs.next()){
					
					User u = new User();
					u.setusername(rs.getString("username"));
					u.setpassword(rs.getString("password"));
					list.add(u);
			}
				
				con.closeResultSet(rs);
				con.closeConnection();
		}catch(SQLException e){e.printStackTrace();}
		}
	
		return list;
		
	}
	
}
