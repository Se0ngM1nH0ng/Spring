<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

<form action="signUp.do" method="post">
	아이디 <input type="text" name="mid" required> <br>
	비밀번호 <input type="password" name="mpw" required> <br>
	이름 <input type="text" name="name" required> <br>
	<input type="submit" value="회원가입">
</form>

</body>
</html>