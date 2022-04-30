<%@page import="user.User"%>
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
	// 바로 파라메타를 전달
	/*
	String username = request.getParameter("username");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	*/
	String[] select = request.getParameterValues("select"); //중복이 되어버리면 배열로 넘어감
	System.out.println(select.length);
	
	for(String str : select) {
		System.out.println(str);
	}
	
	int data = (Integer)request.getAttribute("data"); //다운캐스팅 해줘야함
	System.out.println(data);
	//키값을 넣으면 밸류를 리턴
	
	
	
	//위에서 파라메타를 받을 필요없이 바로 사용가능하다. / 컨트롤러에서 객체를 만들어서 전달하는 방법
	User user = (User)request.getAttribute("user"); // 리퀘스트 저장소에 user라는 키값으로 저장되어 있는 에트리뷰트에서 들고옴.
																		  // 원래는 오브젝트 타입이기에 다운캐스팅이 필요.
%>
	사용자아이디: <%=user.getUsername() %><br>
	연락처: <%=user.getPhone() %><br>
	이메일: <%=user.getEmail() %><br>
	주소: <%=user.getAddress() %>
</body>
</html>