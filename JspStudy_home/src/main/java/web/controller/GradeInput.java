package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/grade-input")
public class GradeInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("test", "test입니다.");
		//request 객체에 test를 담음
		request.getRequestDispatcher("/study/grade/view/grade_input.jsp").forward(request, response);
		//(서블릿안에)dispatcher는 포워드,인클루드를 가능하게 해주는 역활
		// 이 dispatcher는 요청(request안에 들어있음)
		// 위에 객체를 그대로 받아 사용가능
	}

}
