package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tools.JDBConection;

public class RegisterServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		String message="";//提示错误信息
		boolean t=false;//判断用户是否注册成功
		
		/*获取用户提交的表单信息*/
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String passwords=req.getParameter("passwords");
		
		/*如果 用户提交的表单信息任意一项为空，则返回错误信息，注册失败！*/
		if(username.equals("")||password.equals("")||passwords.equals(""))
			message="任意一项都不能为空，请把表单信息填写完整！";
		//否则
		else{
			
			//建立数据库连接
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				
				/*如果用户名已存在，注册失败！*/
				String sql="select * from user where username='"+username+"';";
				ResultSet rs=con.executeQuery(sql);
				try{if(rs.next())
					message="该用户名已存在，注册失败！";
				//否则
				else{
					//如果密码与确认密码不同，注册失败！*/
					if(!password.equals(passwords))
						message="密码与确认密码不同，请重新设定密码注册！";
					//否则，注册成功
					else{
						message="注册成功，请登录！";
						String sqls="insert into user values('"+username+"','"+password+"');";
						con.executeUpdate(sqls);
						t=true;
					}
				}
				}catch(SQLException e){e.printStackTrace();}
				con.closeResultSet(rs);
				con.closeConnection();
			}
		}
		//如果注册失败，返回注册页面
		if(!t){
		req.setAttribute("registerfail", message);
		req.getRequestDispatcher("register.jsp").forward(req, resp);}
		else{
			req.setAttribute("registersuccess", message);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
