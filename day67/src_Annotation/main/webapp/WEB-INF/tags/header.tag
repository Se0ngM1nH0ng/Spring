<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function signUp(){
		// window.open("signUp.jsp","_blank","width=450,height=250");
		location.href="signUp.do";
	}
</script>

<c:if test="${empty member}">
	<form action="login.do" method="post">
		아이디 <input type="text" name="mid" value="${mem.mid}" required> <br>
		비밀번호 <input type="password" name="mpw" value="${mem.mpw}" required> <br>
		<input type="submit" value="로그인">
	</form>
	<br> <button onclick="signUp()">회원가입</button>
</c:if>
<c:if test="${not empty member}">
	<a href="logout.do">로그아웃</a>
	<br>
	<a href="check.do">마이페이지</a>
	<br>
	<a href="insertBoard.do">글 작성</a>
</c:if>