package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.friendsrelationAction;

public class SearchServlet  extends HttpServlet{
private static final long serivalVersionUID=1L;
	
	public SearchServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/xml");
		resp.setCharacterEncoding("UTF-8");
		String selected=req.getParameter("keyword");
		//System.out.println(selected);
		friendsrelationAction fa=new friendsrelationAction();
		List list=fa.FindKeyWord(selected);
		
		PrintWriter out=resp.getWriter();
		//out.println("<response>");
		out.println("<table>");
		for(int i=0;i<list.size();i++){
			//System.out.println("listsizewei"+list.size());
			String s=(String)list.get(i);
			//System.out.println("diyige :"+s);
			 out.println("<tr id=\"sea"+i+"\">");
	         out.println("<td>");
	         out.println("<span>"+s+"</span>");
	         out.println("<span><button type=\"button\" name=\"button\" onclick=\"addfriend()\">ÃÌº”∫√”—</button></span>");
	         out.println("</td></tr>");
		}
		out.println("</table>");
		//out.println("</response>");
		out.flush();
		out.close();
	}
}
