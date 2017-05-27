package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tools.JDBConection;

public class ImpressionAction {

	List<Impression> list = new ArrayList<Impression>();
	
	private String username_one;//��ǰҪ���ҵı����۶���
	private String username_two;//��ǰ�����˶���
	private String impression;//����û����Լ�������
	private String imptime;//��������ʱ��
	
	public ImpressionAction(){
		
	}
	
	//��������ʱ��
	
	public void setImptime(String imptime) {
		this.imptime = imptime;
	}
	
	//���õ�ǰ�ñ����ۻ���
	public void setUsername_one(String username_one) {
		this.username_one = username_one;
	}

	
	//���õ�ǰ���ۻ���
	public void setUsername_two(String username_two) {
		this.username_two = username_two;
	}

	//���ñ��˶��Լ�������
	public void setImpression(String impression) {
		this.impression = impression;
	}

	/*
	 * �鿴ĳһ���ѵ���������
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
	 * �û��Լ��������������,������۵����ݿ�
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
	

