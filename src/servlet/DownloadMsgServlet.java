package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HandleMsg;
import model.User;

public class DownloadMsgServlet extends HttpServlet{
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
	     
	     //获取聊天记录内容
	     String m=req.getParameter("dmsg");
	     
	     //设定文件名为用户名加好友名
	     String filename=username+friendname;
	     
	     //调用HandleMsg里的函数把聊天记录写入txt
	     HandleMsg msg=new HandleMsg();
	     msg.writefile(filename, m);
	}
}
