<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%! 
		String username = "aaaa";
		String password = "1234";
		
		int signin(String username, String password){
			if(this.username.equals(username)){
				if(this.password.equals(password)){
					//로그인 성공
					return 2;
				}else {
					//비밀번호 오류
					return 1;
				}
			}else {
				//아이디 오류
				return 0;
			}
		}
%>

<%
		String _username = request.getParameter("username"); //키 값
		String _password = request.getParameter("password"); // 키 값
		String loginFlag = request.getParameter("login-flag");
		
		
		System.out.println(loginFlag);
		System.out.println(_username + ", " + _password);
		
		int flag = signin(_username, _password); // 위의 두개 변수를 전달 받음
		
		if(flag == 0) { //위에서 검사해서 해당 리턴값의 데이터를 전달받음 그 후 해당 값에 맞는 페이지에 포워드 된다.
%>
		<jsp:forward page="username_error.jsp"></jsp:forward>
<% 	
		}else if(flag == 1) {
%>
		<jsp:forward page="password_error.jsp"></jsp:forward>
<% 			
		}else  {
%>
		<jsp:forward page="signin_success.jsp"></jsp:forward>
<% 	
		}
%>		
		
		
