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
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doPost(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		String message="";
		boolean t=false;
		
		HttpSession session=req.getSession();
		User u=new User();
		
		//��ȡ�û���¼�ύ�ı�
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		//���������һ��Ϊ�գ���¼ʧ��
		if(username.equals("")||password.equals(""))
			message="������Ϊ�գ��������ύ��¼��";
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
						message="��¼�ɹ�";
						t=true;
					}
					else
						message="�û������������";
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
