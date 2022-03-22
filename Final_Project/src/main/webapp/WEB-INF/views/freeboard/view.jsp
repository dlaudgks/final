<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.container {
	width: 100%;
	max-width: 720px;
	margin-left: auto;
	margin-right: auto;
}
</style>
<title>view</title>
</head>
<body>
	<div class="container">
		<h2>
			자유게시판 | <small>글보기</small>
		</h2>
		<p>
			<a href="list">글목록</a><a href="insert">글작성</a>
		</p>
		<div>
			<h4>${one.title }</h4>
			<p style="font-size: small;">
				${one.writer } |
				<fmt:formatDate value="${one.writedate }"
					pattern="yyyy.MM.dd hh:mm:ss" />
			</p>
			<p style="min-height: 300px; white-space: break-spaces">
				<c:out value="${one.content}" />
			</p>
			<div style="margin-top: 10px;">
				<button type="button">수정</button>
				<button type="button">삭제</button>
			</div>
		</div>
	</div>
</body>
</html>