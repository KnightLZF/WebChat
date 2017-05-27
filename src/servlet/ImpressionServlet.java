package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ImpressionAction;
import model.User;

public class ImpressionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/*
	 *处理添加评价的操作
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/xml;charset=utf8");
		resp.setHeader("Catche-Control", "no-cache");
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		
		ImpressionAction imp = new ImpressionAction();
		String username_one = req.getParameter("username_one");
		User user = (User)session.getAttribute("user");
		String text = req.getParameter("text");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		String imptime = sdf.format(date);
//		System.out.println(username_one);
//		System.out.println(user.getusername());
//		System.out.println(text);
		
		imp.setUsername_one(username_one);;
		imp.setUsername_two(user.getusername());;
		imp.setImpression(text);;
		imp.setImptime(imptime);;
		
		imp.InsertMessageIntoDatebase();
		req.getRequestDispatcher("userinfo.jsp?username_info="+username_one).forward(req, resp);
		
	}
	
	

}
