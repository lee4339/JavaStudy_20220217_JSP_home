<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보 입력</h1>
	<form action="/JspStudy_home/study/student1/controller/student_info_controller.jsp" method="get">
		<div>
			<label>학교명</label>
			<input type="text" name="school-name">
		</div>
		<div>
			<label>학생이름</label>
			<input type="text" name="name">
		</div>
		<div>
			<label>학년</label>
			<input type="text" name="student-year">
		</div>
		<div>
			<label>학과</label>
			<input type="text" name="department">
		</div>
		<div>
			<label>학점</label>
			<select name="grade">
				<option value="A+">A+</option>
				<option value="A">A</option>
				<option value="B+">B+</option>
				<option value="B">B</option>
				<option value="C+">C+</option>
				<option value="C">C</option>
				<option value="D+">D+</option>
				<option value="D">D</option>
				<option value="F">F</option>
			</select>
		</div>
		<button>전송</button>
	</form>
</body>
</html>