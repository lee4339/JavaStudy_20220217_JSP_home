package web.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnectionMgr;
import repository.AuthDao;
import repository.AuthDaoImpl;
import web.service.AuthService;
import web.service.AuthServiceImpl;

@WebServlet("/auth/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private AuthService authService;
	
	@Override
	public void init() throws ServletException {
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		AuthDao authDao = new AuthDaoImpl(pool);
		
		authService = new AuthServiceImpl(authDao);
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/auth/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter(); //응답으로 내보낼 출력 스트림을 얻어낸 후, 스트림에 텍스트를 기록.
		
		//요청한 파라메타(매개변수)들을 가져옴
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//가져온 파라메타를 서비스에 넣음
		boolean result = authService.signup(email, name, username, password);
		
		if(result == true) {
			response.sendRedirect("/JspStudy_home/auth/signin"); //로그인화면으로 돌아감
		}else {
			StringBuilder builder = new StringBuilder();
			builder.append("<body>");
			builder.append("<script>");
			
			builder.append("alert(\"회원가입 실패\");");
			builder.append("history.back();");
			
			builder.append("</script>");
			builder.append("<body>");
			
			out.println(builder.toString());
		}
		
	}

}
