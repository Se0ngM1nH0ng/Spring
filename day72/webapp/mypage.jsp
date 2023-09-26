<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>

<script type="text/javascript">
	function del(){
		var ans=confirm("정말 회원탈퇴를 진행하시겠습니까?");
		if(ans){
			location.href="deleteMember.do?mid=${member}";
		}
	}
</script>

<form action="updateMember.do" method="post">
	아이디 <input type="text" name="mid" value="${data.mid}" readonly> <br>
	비밀번호 <input type="password" name="mpw" value="${data.mpw}" required> <br>
	이름 <input type="text" name="name" value="${data.name}" required> <br>
	계정권한 ${data.role} <br>
	<input type="submit" value="회원정보변경">&nbsp;&nbsp;&nbsp;<input type="button" onclick="del()" value="회원탈퇴">
</form>

</body>
</html>