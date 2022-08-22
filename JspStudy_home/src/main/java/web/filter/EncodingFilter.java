package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*") //필터를 먹일 경로
public class EncodingFilter extends HttpFilter implements Filter {
       
	public void init(FilterConfig fConfig) throws ServletException {
		
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
