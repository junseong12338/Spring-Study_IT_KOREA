<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send_check(){
		let f = document.f;
		f.submit();
	}
</script>
</head>			
<body>

 <form name="f"method="post" action="reply">
	<input type="hidden" name="idx" value="${param.idx}">
	<input type="hidden" name="page" value="${param.page}">
		  
	<table border="1"  align="center">
		<caption>:::댓글 쓰기:::</caption>
		<tr>
			<th>제목</th>
			<td><input name="subject" style="width:370px;"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input name="name" style="width:370px;"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="10" cols="50" style="resize:none;"></textarea></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input name="pwd" type="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="resources/img/btn_reg.gif" onclick="send_check();">
				<img src="resources/img/btn_back.gif" onclick="location.href='board_list'">
			</td>
		</tr>
	</table>
	</form> 
</body>
</html>