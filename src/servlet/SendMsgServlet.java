package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MessageAction;
import model.User;

public class SendMsgServlet  extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		resp.setContentType("text/xml;charset=utf8");
		resp.setHeader("Catche-Control", "no-cache");
		//这里最后要改为从session里获取用户名
		//String from="s";
		 User u=(User)req.getSession().getAttribute("user");
	     String from=u.getusername();
		
		String to=req.getParameter("to");
		String msg=req.getParameter("msg");
		
		MessageAction ma=new MessageAction();
		if(ma.sendMsg(from, to, msg))
			System.out.println("成功添加！");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doGet(req, resp);
	}
}
