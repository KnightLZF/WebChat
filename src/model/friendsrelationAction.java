package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class friendsrelationAction {
	List list=new ArrayList();
	private String username;//��ǰ��¼�û���

	public friendsrelationAction(){
		username="";
	}

	//���õ�ǰ�û���
	public void setusername(String s){
		username=s;
	}

	//���ҵ�ǰ�û������к���
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
						// 这一段含义有歧义，因为friendsrelation是一个存放所有用户之间好友关系的数据库。
				}
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return list;
	}

	//ɾ����ǰ�û���һ������
	public boolean DeleteFriends(int i){
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			/*ɾ�����ݿ��еĹ�ϵ���ѱ�������id�ż�1*/
			String sql="delete from friendsrelation where friendsrid='"+i+"'";
			con.executeUpdate(sql);
			String sql2="update friendsrelation set friendsrid=friendsrid-1 where friendsrid>'"+i+"'";
			con.executeUpdate(sql2);
			con.closeConnection();
			return true;
		}
		return false;
	}

	//���Ӻ���s
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

	//�����û�
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
						//System.out.println("���ҵ�"+u);
				}
					//System.out.println(list.size());
					con.closeResultSet(rs);
					con.closeConnection();
			}catch(SQLException e){e.printStackTrace();}
			}
			return list;
		}
}
