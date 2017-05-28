package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConection {
	private final String dbDriver="com.mysql.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/WebChat?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private final String userName="root";
	private final String password="fly";
	private ResultSet rs=null;
	private Statement stmt=null;
	private Connection con=null;
	
	public JDBConection(){
		try{
			Class.forName(dbDriver).newInstance();
		}catch(Exception e){
			System.out.println(" ˝æ›ø‚º”‘ÿ ß∞‹£°");
		}
	}
	public boolean createConnection(){
		try{
			con=DriverManager.getConnection(url, userName, password);
			con.setAutoCommit(true);
			return true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ResultSet executeQuery(String sql){
		try{
			if(null==con){
				createConnection();
			}
			stmt=con.createStatement();
			try{
				rs=stmt.executeQuery(sql);
				return rs;
			}catch(SQLException e){
				System.out.println(e.getMessage());
				return null;
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	public boolean executeUpdate(String sql){
		if(null==con){
			createConnection();
		}
		try{
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	public void closeResultSet(ResultSet r){
		if(null!=r){
			try{
				r.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void closeConnection(){
		if(null!=rs){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(null!=stmt){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(null!=con){
			try{
				con.close();
			}catch(SQLException e){
			}finally{
				con=null;
			}
		}
	}
}
