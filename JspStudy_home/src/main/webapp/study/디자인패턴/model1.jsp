<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		int num = 90;
		if(num > 89) {
	%>
		<p>A학점</p>
	<%
		}else if(num > 79) {
	%>
		<p>B학점</p>
	<% 
		}else if(num > 69) {
	%>
		<p>C학점</p>
	<% 
		}	
	%>		
	
</body>
</html>