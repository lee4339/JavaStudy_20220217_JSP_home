<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="student.Student" %>

<%
	//파라메터는 무조건 스트링값으로 들어가기에 다른 값일시 변환해줘야함
	Student student = Student.builder()
								.schoolName(request.getParameter("school-name"))
								.name(request.getParameter("name"))
								.studentYear(Integer.parseInt(request.getParameter("student-year")))
								.department(request.getParameter("department"))
								.grade(request.getParameter("grade"))
								.build();
								
	request.setAttribute("student", student);
%>

<jsp:forward page="../view/student_info_show.jsp"></jsp:forward>