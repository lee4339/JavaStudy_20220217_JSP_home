<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*여러가지 자료를 받아오기 때문에 배열인 getParameterValues 사용*/
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
%>







