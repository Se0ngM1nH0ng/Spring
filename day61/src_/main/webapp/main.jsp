<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

<kim:header />

<hr>

<form action="main.do">
	<select name="searchCondition">
		<option value="TITLE">제목</option>
		<option value="WRITER">작성자</option>
	</select>
	<input type="text" name="searchContent" placeholder="검색어를 입력하세요.">
	<input type="submit" value="검색">
</form>
<br>
<table border="1">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th><th>조회수</th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td>${v.bid}</td><td>${v.title}</td><td>${v.writer}</td><td>${v.cnt}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>