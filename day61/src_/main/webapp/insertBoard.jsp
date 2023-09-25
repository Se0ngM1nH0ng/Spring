<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성페이지</title>
</head>
<body>

<form action="insertBoard.do" method="post">
	<input type="hidden" name="writer" value="${member}">
	<input type="text" name="title" required placeholder="제목 작성"> <br>
	<input type="text" name="content" required placeholder="내용 작성"> <br>
	<input type="submit" value="글 작성">
</form>

<hr>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>