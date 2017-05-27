package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import Tools.JDBConection;

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		String message="";
		boolean t=false;
		
		HttpSession session=req.getSession();
		User u=new User();
		
		//获取用户登录提交的表单
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		//如果表单任意一项为空，登录失败
		if(username.equals("")||password.equals(""))
			message="表单不能为空，请重新提交登录！";
		else{
			JDBConection con=new JDBConection();
			if(con.createConnection()){
				String sql="select * from user where username='"+username+"' and password='"+password+"';";
				ResultSet rs=con.executeQuery(sql);
				try{
					if(rs.next()){
						u.setusername(username);
						u.setpassword(password);
						session.setAttribute("user", u);
						message="登录成功";
						t=true;
					}
					else
						message="用户名或密码错误！";
				}catch(SQLException e){e.printStackTrace();}
			}
		}
		
		if(!t){
			req.setAttribute("loginfail", message);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
	}
}
