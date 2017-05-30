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
		
		//��ȡ��������
		String friendname=req.getParameter("to");
		
		//����Ӧ��Ҳ�Ǵ�session���ȡ�û���
		//String username="s";
		
		 User u=(User)req.getSession().getAttribute("user");
	     String username=u.getusername();
	     
	     //��ȡ�����¼����
	     String m=req.getParameter("dmsg");
	     
	     //�趨�ļ���Ϊ�û����Ӻ�����
	     String filename=username+friendname;
	     
	     //����HandleMsg��ĺ����������¼д��txt
	     HandleMsg msg=new HandleMsg();
	     msg.writefile(filename, m);
	}
}
