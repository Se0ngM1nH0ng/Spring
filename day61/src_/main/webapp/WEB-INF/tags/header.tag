<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty member}">
	<form action="login.do" method="post">
		아이디 <input type="text" name="mid" required> <br>
		비밀번호 <input type="password" name="mpw" required> <br>
		<input type="submit" value="로그인">
	</form>
</c:if>
<c:if test="${not empty member}">
	<a href="logout.do">로그아웃</a>
	<br>
	<a href="insertBoard.do">글 작성</a>
</c:if>