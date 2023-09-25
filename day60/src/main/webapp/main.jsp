<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.spring.biz.board.BoardVO,java.util.ArrayList" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<script src="js/main.js"></script>

<kim:login />

<hr>

<kim:printBoardList border="1">게시글 목록</kim:printBoardList>

<br>

<kim:btn>게시글 작성</kim:btn>

</body>
</html>