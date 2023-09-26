<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성페이지</title>
</head>
<body>

<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${member}">
	<input type="text" name="title" required placeholder="제목 작성"> <br>
	<input type="text" name="content" required placeholder="내용 작성"> <br>
	<input type="file" name="fileUpload" onchange="thumbnail(this);"> <br>
	<input type="submit" value="글 작성">
</form>

<hr>
<img alt="썸네일" src="" id="thumbnailImage">
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