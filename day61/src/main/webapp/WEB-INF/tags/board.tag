<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${data.writer ne mid}">
	<form name="form" action="updateBoard.do" method="post">
		글 번호: <input type="text" name="num" value="${data.num}" readonly> <br>
		글 제목: <input type="text" name="title" value='${data.title}' readonly> <br>
		글 내용: <input type="text" name="content" value='${data.content}' readonly> <br>
		작성자: <input type="text" name="writer" value='${data.writer}' readonly>
	</form>
</c:if>



<c:if test="${data.writer eq mid}">
	<form name="form" action="updateBoard.do" method="post">
		글 번호: <input type="text" name="num" value="${data.num}" readonly> <br>
		글 제목: <input type="text" name="title" value='${data.title}'> <br>
		글 내용: <input type="text" name="content" value='${data.content}'> <br>
		작성자: <input type="text" name="writer" value='${data.writer}' readonly> <br>
		<input type="submit" value="게시글 변경"> <input type="button" value="게시글 삭제" onClick="delBoard(${data.num})">
	</form>
</c:if>