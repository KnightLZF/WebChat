package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	public static final String login_page="/WebChat/index.jsp";
	public static final String homepage="WebChat/main.jsp";
    public void init(FilterConfig filterConfig)throws ServletException{
		
	}
	public void destroy(){
		
	}
	
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		String currentURL=req.getRequestURI();
		System.out.println("µ±Ç°url£º"+currentURL);
		if(!currentURL.equals("/WebChat/register.jsp")&&!currentURL.equals("/WebChat/")&&!currentURL.equals("/WebChat/index.jsp")){
			HttpSession session=req.getSession();
			if(session.getAttribute("user")==null){
				System.out.println(currentURL);
				resp.sendRedirect("/WebChat/index.jsp");
				return;
			}
		}
		chain.doFilter(req,resp);
	}
}
