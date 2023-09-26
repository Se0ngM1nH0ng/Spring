<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

<img alt="디폴트 이미지" src="images/default.jpg" id="photo">

<script type="text/javascript">
	var cnt = 1; // scope 이슈 확인할것
	
	$("#photo").on("click",function(){
		console.log("cnt : "+cnt);
		
		var testData={count:cnt, apple:1234, banana:'kiwi'}; // JSON 데이터
		
		$.ajax({
			url : "test02.do",
			type : "POST",
			data : testData,
			success : function(result){
				console.log("성공: "+result);
				cnt=result;
				if(cnt%2==0){
					$("#photo").prop("src","images/test.png");
				}
				else{
					$("#photo").prop("src","images/default.jpg");
				}
			},
			error : function(){
				console.log("로그 : 에러발생...");
			}
		});
	});
</script>

</body>
</html>