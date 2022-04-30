<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%
	request.setAttribute("data", 100); 
	// hashmap과 비슷, 키값과 밸류 / 업캐스팅되어서 오브젝트로 값이 들어감
	User user = User.builder()
					.username(request.getParameter("username"))
					.phone(request.getParameter("phone"))
					.email(request.getParameter("email"))
					.address(request.getParameter("address"))
					.build();
	
	request.setAttribute("user", user);
%>

<jsp:forward page="../view/user_info_show.jsp"></jsp:forward>