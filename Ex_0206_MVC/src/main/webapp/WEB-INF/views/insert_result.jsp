<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>이름 : ${dto.name }</p>
<p>나이 : ${dto.age }</p>
<p>전화번호 : ${dto.tel }</p>

<input type="button" value="돌아가기" onclick="location.href='insert_form'">
</body>
</html>