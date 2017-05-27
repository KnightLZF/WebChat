package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class ImpressionAction {

	List<Impression> list = new ArrayList<Impression>();
	
	private String username_one;//当前要查找的被评价对象
	private String username_two;//当前评价人对象
	private String impression;//别的用户对自己的评价
	private String imptime;//设置评论时间
	
	public ImpressionAction(){
		
	}
	
	//设置评论时间
	
	public void setImptime(String imptime) {
		this.imptime = imptime;
	}
	
	//设置当前用被评价户名
	public void setUsername_one(String username_one) {
		this.username_one = username_one;
	}

	
	//设置当前评价户名
	public void setUsername_two(String username_two) {
		this.username_two = username_two;
	}

	//设置被人对自己的评价
	public void setImpression(String impression) {
		this.impression = impression;
	}

	/*
	 * 查看某一好友的所有评价
	 */
	public List<Impression> SelectImpression(){
	
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			String sql="select * from impression where userone="+username_one;
			ResultSet rs=null;
			
			
			try{
				rs=con.executeQuery(sql);
				while(rs.next()){
					
					Impression imp = new Impression();
					imp.setImpid(rs.getInt("impid"));
					imp.setUserone(rs.getString("userone"));
					imp.setUsertwo(rs.getString("usertwo"));
					imp.setImpression(rs.getString("impression"));
					imp.setImptime(rs.getString("date"));
					list.add(imp);
			}
				
				con.closeResultSet(rs);
				con.closeConnection();
		}catch(SQLException e){e.printStackTrace();}
		}
	
		return list;
		
	}
	
	/*
	 * 用户自己给好友添加评价,添加评价到数据库
	 */
	public void InsertMessageIntoDatebase(){
		
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			String sql = "insert into impression (`userone`, `usertwo`, `impression`,`date`) values ("+username_one+","+username_two+",'"+impression+"','"+imptime+"')";
			ResultSet rs=null;
			try{
				con.executeUpdate(sql);
		}catch(Exception e){e.printStackTrace();}
			con.closeResultSet(rs);
			con.closeConnection();
		}
		
	}
}
	

