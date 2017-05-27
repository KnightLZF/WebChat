package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Message;
import model.MessageAction;
import model.User;
import model.friendsrelationAction;

public class GetMsgServlet   extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("UTF-8");
		
		String friendname=req.getParameter("to");
		
		//这里应该也是从session里获取用户名
		//String username="s";
		
		 User u=(User)req.getSession().getAttribute("user");
	     String username=u.getusername();
	       
		
		MessageAction ma=new MessageAction();
		List list=ma.FindAllMsg(username, friendname);
		
		StringBuffer s=new StringBuffer();

		for(int i=0;i<list.size();i++){
			Message m=(Message)list.get(i); 
			s.append(m.getfrom()+":"+m.getmsg()+"    "+m.gettime()+"\n");
		}
		String s2=new String(s);
		//System.out.println(s2);
		PrintWriter out=resp.getWriter();
		out.write(s2);
		out.close();
		req.setAttribute("chatmessage", s2);
		
	}
}
