<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>

<form action="insertBoard.do" method="post">
	제목 <input type="text" name="title"> <br>
	내용 <input type="text" name="content"> <br>
	작성자 <input type="text" name="writer" value='${mid}' readonly> <br>
	<input type="submit" value="게시글 작성">
</form>

<br>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>