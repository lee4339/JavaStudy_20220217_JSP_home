package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/auth/signin.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 등 인증관련 문제에서는 get요청시 보안이 안되기에 예외적으로 post를 사용한다.(로그인은 R)
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	}

}
