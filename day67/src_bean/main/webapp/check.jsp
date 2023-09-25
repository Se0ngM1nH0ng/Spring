<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체크페이지</title>
</head>
<body>

<form action="mypage.do" method="post">
	<input type="hidden" name="mid" value="${member}">
	비밀번호 확인 <input type="password" name="mpw" required> <br>
	<input type="submit" value="마이페이지">
</form>

</body>
</html>