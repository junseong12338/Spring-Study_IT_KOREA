<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f){
		f.action="insert";
		f.method ="post";
		f.submit();
	}
</script>
</head>
<body>
<form>
		<table border="1" align="center">
			<caption>::새글 작성하기::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name" style="width:250px;"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>						
					<textarea row="5" cols="50" name="content" style="resize:none;"wrap="on"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="등록하기" onclick="send(this.form);">
				<input type="button" value="목록으로" onclick="location.href='visit_list'">
			</td>
			</tr>
		
		</table>
	
	</form>
</body>
</html>