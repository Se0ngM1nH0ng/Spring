<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<c:forEach var="v" items="${searchMap}">
			<option value="${v.value}">${v.key}</option>
		</c:forEach>
	</select>
	<input type="text" name="searchContent" placeholder="검색어를 입력하세요.">
	<input type="submit" value="검색">
</form>
<br>
<c:if test="${fn:length(datas) <= 0}">
	<h1>출력할 게시글이 존재하지않습니다!</h1>
</c:if>
<c:if test="${fn:length(datas) > 0}">
<table border="1">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th><th>조회수</th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="board.do?bid=${v.bid}">${v.bid}</a></td><td>${v.title}</td><td>${v.writer}</td><td>${v.cnt}</td>
		</tr>
	</c:forEach>
</table>
</c:if>

</body>
</html>