package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class friendsrelationAction {
	List list=new ArrayList();
	private String username;//当前登录用户名
	private String username_add;//要被添加的用户名
	private int id;//设置id参数
	
	public friendsrelationAction(){
		username="";
	}
	
	//设置当前用户名
	public void setusername(String s){
		username=s;
	}
	
	//设置要被添加的用户名字
	public void setUsername_add(String username_add) {
		this.username_add = username_add;
	}
	
	
	public void setId(int id) {
		this.id = id;
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

	
	//查找当前用户的各个分组里的好友,i指的是分组id，1为好友，2为家人，3为同学，4为同事，5为陌生人
		public List<friendsrelation> FindinFriends(int i){
			List<friendsrelation> lists=new ArrayList();
			//连接数据库
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				//从数据库中找出当前用户在好友分组里的好友
				String sql="select * from friendsrelation where (nameone='"+username+"' and grouponeid='"+i+"') or (nametwo='"+username+"' and grouptwoid='"+i+"');";
				
				//获取结果集
				ResultSet rs=null;
				try{
					rs=con.executeQuery(sql);
					while(rs.next()){
						friendsrelation com=new friendsrelation();
						lists.add(com);
						
						com.setid(rs.getInt("friendsrid"));
						
						String s = rs.getString("nameone");
						if(s.equals(username)){
						 com.setnameone(s);
						 com.setnametwo(rs.getString("nametwo"));
						 com.setgroupid(rs.getInt("grouponeid"));
						}else{
							com.setnametwo(s);
							com.setnameone(rs.getString("nametwo"));
							com.setgroupid(rs.getInt("grouptwoid"));
						}
				}
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return lists;
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
//	public boolean AddFriends(String s){
//		JDBConection con=new JDBConection();
//		if(con.createConnection()){
//			String sql1="select Max(id) from friendsrelation;";
//			ResultSet rs1=con.executeQuery(sql1);
//			if(rs1!=null){
//				
//			}
//		}
//		return false;
//	}
	
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
		
		
	//查找当前所有ID
		public List<friendsrelation> SelectMaxId(){
			JDBConection con=new JDBConection();
			friendsrelation f = new friendsrelation();
			if(con.createConnection()){
				String sql="select friendsrid from friendsrelation;";
				try {
					ResultSet rs=con.executeQuery(sql);
					while(rs.next()){
					f.setid(rs.getInt("friendsrid"));
					list.add(f);
					}
				

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return list;
		}
		
	//添加朋友
		public void AddFriends(){
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				String sql="insert into friendsrelation(friendsrid,`nameone`,`nametwo`) values("+id+","+username+","+username_add+");";
				try{
					con.executeUpdate(sql);
					con.closeConnection();
			}catch(Exception e){e.printStackTrace();}
			}
		}
}

