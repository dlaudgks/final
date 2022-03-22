<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
<style>
input, textarea, button {
	padding: 5px;
}

a {
	text-decoration: none;
}

a:link {
	color: #000000;
}

.container {
	width: 100%;
	max-width: 720px;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
<div class="container">
	<div>
		<h2>자유게시판 | <small>글쓰기</small></h2>
		<a href="list">글목록</a>
	</div>
	<form method="post" action="/">
	<div>
		<input type="text" placeholder="글제목" />
	</div>
	<div style="margin-top: 10px;">
		<textarea rows="10" cols="20" name="content" placeholder="글내용"></textarea>
	</div>
	<div>
	<button type="submit">등록</button>
	<button type="button">취소</button>
	</div>
	</form>
</div>
</body>
</html>
<jsp:include page="/WEB-INF/views/include/bottom.jsp"/>