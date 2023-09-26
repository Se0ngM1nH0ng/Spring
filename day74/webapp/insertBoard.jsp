<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성페이지</title>
</head>
<body>

<h1><a href="insertBoard.do?lang=en">EN</a> | <a href="insertBoard.do?lang=ko">KO</a></h1>

<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${member}">
	<input type="text" name="title" required placeholder="<spring:message code='header.title' />"> <br>
	<input type="text" name="content" required placeholder="<spring:message code='header.content' />"> <br>
	<input type="file" name="fileUpload" onchange="thumbnail(this);"> <br>
	<input type="submit" value="<spring:message code='header.btn' />">
</form>

<hr>
<img alt="<spring:message code='body.image' />" src="" id="thumbnailImage">
<hr>

<a href="main.do"><spring:message code="footer.gobackmain" /></a>

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