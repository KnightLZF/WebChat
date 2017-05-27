package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.friendsrelationAction;

import Tools.JDBConection;

public class DeleteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		resp.setContentType("text/xml;charset=utf-8");
		resp.setHeader("Catche-Control", "no-cache");
		JDBConection con=new JDBConection();
		String itemid=req.getParameter("friendid");
		int i=Integer.parseInt(itemid);
		friendsrelationAction fa=new friendsrelationAction();
		fa.DeleteFriends(i);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		this.doGet(req, resp);
	}
}
