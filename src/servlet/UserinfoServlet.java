package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Userinfo;
import model.UserinfoAction;

public class UserinfoServlet extends HttpServlet{

	/**
	 * ��ѯ�û�����ϸ����
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml;charset=utf-8");
		resp.setHeader("Catche-Control", "no-cache");
		req.setCharacterEncoding("utf-8");
		
		//��ȡ���͹����ĺ�����
		String username_info = req.getParameter("username_info");
		System.out.println(username_info);
		
		//���ò�ѯ����
		UserinfoAction uia = new UserinfoAction();
		uia.setUsername(username_info);
		List<Userinfo> list = uia.SelectUsersInfo();
		if(list.size()>0){
			System.out.println("��ѯ�ɹ�");
			HttpSession session = req.getSession();
			session.setAttribute("user_info", list);
		}else{
			System.out.println("��ѯʧ��");
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
