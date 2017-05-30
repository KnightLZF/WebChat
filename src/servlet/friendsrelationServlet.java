package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.friendsrelation;
import model.friendsrelationAction;

public class friendsrelationServlet extends HttpServlet{

	/**
	 * 执行添加好友操作
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String nametwo = req.getParameter("user_name_two");
		User nameone = (User)session.getAttribute("user");
		friendsrelationAction fa = new friendsrelationAction();
		
		List<friendsrelation> list= fa.SelectMaxId();
		int maxid = list.get(list.size()-1).getid()+1;
		
		
		fa.setId(maxid);
		fa.setusername(nameone.getusername());
		fa.setUsername_add(nametwo);
		
		fa.AddFriends();
		System.out.println("添加成功");	
		req.getRequestDispatcher("userinfo.jsp?username_info="+nametwo).forward(req, resp);;
		
	}
	
	
	
}
