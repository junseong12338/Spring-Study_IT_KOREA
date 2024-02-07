<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YoilTeller</title>

<script type="text/javascript">
	function send1(f) {
		let name = f.name.value
		let age = f.age.value
		let tel = f.tel.value
		
		if(name == ''){
			alert('이름을 입력하세요')
			return;
		}
		
		if(age == ''){
			alert('나이를 입력하세요')
			return;
		}
		
		if(tel == ''){
			alert('번호를 입력하세요')
			return;
		}
		
		f.action = 'insert1';
		f.method = 'get';
		f.submit();
	}
	
	function send2(f) {
		let name = f.name.value
		let age = f.age.value
		let tel = f.tel.value
		
		if(name == ''){
			alert('이름을 입력하세요')
			return;
		}
		
		if(age == ''){
			alert('나이를 입력하세요')
			return;
		}
		
		if(tel == ''){
			alert('번호를 입력하세요')
			return;
		}
		
		f.action = 'insert2';
		f.method = 'get';
		f.submit();
	}
	
	
</script>
</head>
<body>
	<form>
	<table border="1" align="center">
		<caption>:::개인정보 입력:::</caption>
		<tr>
		<th>이름</th>
		<td><input name="name"></td>
		</tr>
		
		<tr>
		<th>나이</th>
		<td><input name="age"></td>
		</tr>
		
		<tr>
		<th>전화번호</th>
		<td><input name="tel"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="낱개로 받기"
							onclick="send1(this.form);">
				<input type="button" value="객체로 받기"
							onclick="send2(this.form);">
		</tr>
	</table>
	</form>
</body>
</html>