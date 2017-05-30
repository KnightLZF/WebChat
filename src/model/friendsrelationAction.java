package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class friendsrelationAction {
	List list=new ArrayList();
	private String username;//锟斤拷前锟斤拷录锟矫伙拷锟斤拷

	public friendsrelationAction(){
		username="";
	}

	//锟斤拷锟矫碉拷前锟矫伙拷锟斤拷
	public void setusername(String s){
		username=s;
	}

	//锟斤拷锟揭碉拷前锟矫伙拷锟斤拷锟斤拷锟叫猴拷锟斤拷
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
						// 杩欎竴娈靛惈涔夋湁姝т箟锛屽洜涓篺riendsrelation鏄竴涓瓨鏀炬墍鏈夌敤鎴蜂箣闂村ソ鍙嬪叧绯荤殑鏁版嵁搴撱�
				}
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return list;
	}
	
		public List<friendsrelation> FindinFriends(int i){
			List<friendsrelation> lists=new ArrayList();
		
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				
				String sql="select * from friendsrelation where (nameone='"+username+"' and grouponeid='"+i+"') or (nametwo='"+username+"' and grouptwoid='"+i+"');";
				
				
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
		

	//删锟斤拷锟斤拷前锟矫伙拷锟斤拷一锟斤拷锟斤拷锟斤拷
	public boolean DeleteFriends(int i){
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			/*删锟斤拷锟斤拷锟捷匡拷锟叫的癸拷系锟斤拷锟窖憋拷锟斤拷锟斤拷锟斤拷id锟脚硷拷1*/
			String sql="delete from friendsrelation where friendsrid='"+i+"'";
			con.executeUpdate(sql);
			String sql2="update friendsrelation set friendsrid=friendsrid-1 where friendsrid>'"+i+"'";
			con.executeUpdate(sql2);
			con.closeConnection();
			return true;
		}
		return false;
	}

	//锟斤拷锟接猴拷锟斤拷s
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

	//锟斤拷锟斤拷锟矫伙拷
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
						//System.out.println("锟斤拷锟揭碉拷"+u);
				}
					//System.out.println(list.size());
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return list;
		}
}
