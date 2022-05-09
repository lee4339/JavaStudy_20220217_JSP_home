package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc-grade") // 대문자, _ 사용 x 
public class CalcGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); // response.getWriter 먼저 작성하면 어떤객체인지 마우스를 올리면 볼 수 있음. 
		
		String[] subjects = request.getParameterValues("subject");
		String[] grade = request.getParameterValues("grade");
		String[] time = request.getParameterValues("time");
		
		double score = 0;
		int totalTime = 0;
		double gradeAvg = 0;
		
		for(int i = 0; i < subjects.length; i++) {
			totalTime += Integer.parseInt(time[i]);
			
			if(grade[i].equals("A+")) {
				score += (4.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("A")) {
				score += (4.0 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("B+")) {
				score += (3.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("B")) {
				score += (3.0 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("C+")) {
				score += (2.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("C")) {
				score += (2.0 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("D+")) {
				score += (1.5 * Integer.parseInt(time[i]));
			}else if(grade[i].equals("D")) {
				score += (1.0 * Integer.parseInt(time[i]));
			}else {
				score += 0;
			}
		}
		
		gradeAvg = score/totalTime;
		
		StringBuilder builder = new StringBuilder();  /* 포워드 대신 안에서 스크립트를 사용*/
		builder.append("<body>");
		builder.append("<script>"); //문자열을 만들어준다. 
		builder.append("alert(\"총 평점: " + gradeAvg + "\");");
		builder.append("history.back();"); //뒤로가기와 같은 기능 alert창 띄우고 뒤로가기
		builder.append("</script>"); 
		builder.append("</body>");
		
		
		System.out.println(builder.toString());
		
		out.write(builder.toString());
	}
	
	
//		response.setContentType("text/plain;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		
//		String grade = request.getParameter("grade");
//		
//		PrintWriter out = response.getWriter();
//		// PrintWriter = out / response안에 들어있음.(응답)
//		out.println("학생의 성적: " + grade);
//	}

}

