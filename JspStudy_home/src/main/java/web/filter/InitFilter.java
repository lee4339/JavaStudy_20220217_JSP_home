package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import db.DBConnectionMgr;
import repository.AuthDao;
import repository.AuthDaoImpl;
import repository.UserDao;
import repository.UserDaoImpl;

@WebFilter("/*") //필터를 먹일 경로
public class InitFilter extends HttpFilter implements Filter {
    
	private DBConnectionMgr pool;
	private AuthDao authDao;
	private UserDao userDao;
	
	public void init(FilterConfig fConfig) throws ServletException {
		pool = DBConnectionMgr.getInstance();
		authDao = new AuthDaoImpl(pool);
		userDao = new UserDaoImpl(pool);
		
		ServletContext servletContext = fConfig.getServletContext();
		servletContext.setAttribute("authDao", authDao);
		servletContext.setAttribute("userDao", userDao);
	}
    

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//서블릿 실행 전 필터
		//System.out.println("doFilter() 전처리");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response); //서블릿 실행
		
		//서블릿 실행 후 필터
		//System.out.println("doFilter() 후처리");
	}

	public void destroy() {
		
	}

}
