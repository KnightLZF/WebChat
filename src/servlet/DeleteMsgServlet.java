package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HandleMsg;
import model.User;

public class DeleteMsgServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("UTF-8");
		
		//获取好友姓名
		String friendname=req.getParameter("to");
		
		//这里应该也是从session里获取用户名
		//String username="s";
		
		 User u=(User)req.getSession().getAttribute("user");
	     String username=u.getusername();
	     
	     //设定文件名为用户名加好友名
	     String filename=username+friendname;
	     
	     //删除该文件
	     HandleMsg msg=new HandleMsg();
	     msg.delFile(filename);
	}
}

