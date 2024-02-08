<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href ="resources/css/visit.css">
</head>
<body>
	<div id="main_box">
		<h1>방명록 리스트</h1>	
		<input type="button" value="글쓰기" onclick="location.href='insert_form'">
	</div>
	
	<c:forEach var="dto" items="${list}">
		<div class="visit_box">
		<div class="type_content"><pre>${dto.content}</pre></div>
		<div class="type_name">작성자 : ${dto.name}(${dto.ip})</div>
		<div class="type_regdate">작성일 ${dto.regdate }</div>
		<div>	
		<form>
			<input type="hidden" name="idx" value="${vo.idx }">
			비밀번호 <input type="password" name = "pwd">
			<input type="button" value="수정" onclick="modify(this.form)">
			<input type="button" value="삭제" onclick="del(this.form)">
		</form>

		</div>
		</div>

	</c:forEach>
</body>
</html>