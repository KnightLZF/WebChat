package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Tools.JDBConection;

public class MessageAction {
	
	//发送消息
	public boolean sendMsg(String from,String to,String msg){
		JDBConection con=new JDBConection();
		boolean t=false;
		if(con.createConnection()){
			String sql1="select Max(msgid) from message;";
			ResultSet rs1=con.executeQuery(sql1);
			int msgid=0;
			try{
				if(rs1.next())
					msgid=rs1.getInt("Max(msgid)");
				msgid++;
				
				//获取时间
				Date now=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
				String time=sdf.format(now);
				
				String sql2="insert into message values('"+msgid+"','"+from+"','"+to+"','"+msg+"','"+time+"');";
				con.executeUpdate(sql2);
				t=true;
				}catch(SQLException e){e.printStackTrace();}
			con.closeResultSet(rs1);
			con.closeConnection();
		}
		return t;
	}
	
	
	//显示所有消息
	public List FindAllMsg(String username,String friendname){
		List list=new ArrayList();
		
		JDBConection con=new JDBConection();
		if(con.createConnection()){
			String sql="select * from message where message.from in('"+username+"','"+friendname+"') and message.to in('"+username+"','"+friendname+"') order By message.time;";
			ResultSet rs=con.executeQuery(sql);
			try{
				while(rs.next()){
					Message m=new Message();
					list.add(m);
					
					m.setmsgid(rs.getInt("msgid"));
					m.setfrom(rs.getString("from"));
					m.setto(rs.getString("to"));
					m.setmsg(rs.getString("msg"));
					m.settime(rs.getString("time"));
				}
			}catch(SQLException e){e.printStackTrace();}
			con.closeResultSet(rs);
			con.closeConnection();
		}
		return list;
	}
}
