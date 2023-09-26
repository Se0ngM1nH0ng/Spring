<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>

<script type="text/javascript">
	function del(bid){
		var ans=confirm("정말 삭제하시겠습니까?");
		if(ans){
			location.href="deleteBoard.do?bid="+bid;
		}
	}
</script>

<c:if test="${empty data}">
	<h1>해당 게시글은 없거나 이용이 불가능한 게시글입니다!</h1>
</c:if>
<c:if test="${not empty data}">
<form action="updateBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bid" value="${data.bid}">
	<input type="text" name="writer" value="${data.writer}" disabled> <br>
	<input type="text" name="title" required value="${data.title}"> <br>
	<input type="text" name="content" required value="${data.content}"> <br>
	<input type="file" name="fileUpload" onchange="thumbnail(this);"> <br>
	<c:if test="${data.writer eq member}">
		<input type="submit" value="글 변경">&nbsp;&nbsp;&nbsp;<input type="button" onclick="del(${data.bid})" value="글 삭제">
	</c:if>
</form>
</c:if>
<hr>
<c:if test="${empty data.fileName}">
	<img alt="기본 이미지" src="images/default.jpg" id="thumbnailImage">
</c:if>
<c:if test="${not empty data.fileName}">
	<img alt="${data.fileName}" src="images/${data.fileName}" id="thumbnailImage">
</c:if>
<hr>

<a href="main.do">메인으로 돌아가기</a>

<script>
	function thumbnail(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById('thumbnailImage').src = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
		}
		else {
			document.getElementById('thumbnailImage').src = "";
		}
    }
</script>
</body>
</html>