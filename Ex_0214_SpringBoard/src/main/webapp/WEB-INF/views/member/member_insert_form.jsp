<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
		<table border="1">
			<caption>:::회원가입:::</caption>
			
			<tr>
				<th>아이디</th>
				<td> <input name="id" id="id" type="button" value="중복체크" onclick="check_id()">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
				<input name="name">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				<input name="pwd" type="password">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
				<input name="email">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="가입" onclick="send(this.form);">
					<input type="button" value="취소" onclick="location.href='board_list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>