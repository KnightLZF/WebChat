package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class friendsrelationAction {
	List list=new ArrayList();
	private String username;//当前登录用户名
	
	public friendsrelationAction(){
		username="";
	}
	
	//设置当前用户名
	public void setusername(String s){
		username=s;
	}
	
	//查找当前用户的所有好友
	public List<friendsrelation> FindAllFriends(){
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				String sql="select * from friendsrelation where nameone='"+username+"' or nametwo='"+username+"';";
				ResultSet rs=null;
				try{
					rs=con.executeQuery(sql);
					while(rs.next()){
						friendsrelation com=new friendsrelation();
						list.add(com);
						
						com.setid(rs.getInt("friendsrid"));
						
						String s = rs.getString("nameone");
						if(s.equals(username)){
						 com.setnameone(s);
						 com.setnametwo(rs.getString("nametwo"));
						}else{
							com.setnametwo(s);
							com.setnameone(rs.getString("nametwo"));
						}
				}
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return list;
	}
	
	//删除当前用户的一个好友
	public boolean DeleteFriends(int i){
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			/*删除数据库中的关系并把比它大的id号减1*/
			String sql="delete from friendsrelation where friendsrid='"+i+"'";
			con.executeUpdate(sql);
			String sql2="update friendsrelation set friendsrid=friendsrid-1 where friendsrid>'"+i+"'";
			con.executeUpdate(sql2);
			con.closeConnection();
			return true;
		}
		return false;
	}
	
	//添加好友s
	public boolean AddFriends(String s){
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			String sql1="select Max(id) from friendsrelation;";
			ResultSet rs1=con.executeQuery(sql1);
			if(rs1!=null){
				
			}
		}
		return false;
	}
	
	//查找用户
		public List<User> FindKeyWord(String s){
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				String sql="select * from user where username like '%"+s+"%';";
				ResultSet rs=null;
				User u = new User();
				try{
					rs=con.executeQuery(sql);
					while(rs.next()){
						
						u.setusername(rs.getString("username"));
						list.add(u);
						//System.out.println("查找到"+u);
				}
					//System.out.println(list.size());
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return list;
		}
}

