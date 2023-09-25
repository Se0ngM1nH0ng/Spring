<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="border" %>

<h2><jsp:doBody /></h2>

<hr>

<table border="${border}">
	<tr>
		<th>글 제목</th><th>작성자</th><th>내용</th>
	</tr>
	<c:forEach var="v" items="${datas}">
	<tr>
		<td>${v.title}</td>
		<td>${v.writer}</td>
		<td>${v.content}</td>
	</tr>
	</c:forEach>
</table>