<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<style>
table {
	border-collapse: collapse;
}

th, td {
	border-bottom: 1px solid;
	padding: 4px;
	text-align: left;
}

thead th {
	border-bottom: 2px solid;
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
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<div class="container">
		<div style="border-bottom: 1px solid; margin-bottom: 30px;">
			<h2>
				자유게시판 <small>| 글전체목록</small>
			</h2>
			<p style="margin-left: 20px;">
			<c:choose>
			<c:when test="${auth eq null or auth eq false }">
				</c:when>
				<c:otherwise>
					<b>${loginVo.name }</b> 님, 이용중 
				</c:otherwise>
			</c:choose>
				<a href="/freeboard/insert">글쓰기</a>
			</p>
		</div>
		<div style="margin-left: 20px;">
			<form action="/freeboard/view">
				<input name="no"/> <button>글번호</button>
			</form>
			<table style="width: 85%">
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="one" items="${all }">
						<tr>
							<td>${one.no }</td>
							<td><a href="/freeboard/view?no=${one.no }">${one.title }</a></td>
							<td>${one.writer }</td>
							<td><fmt:formatDate value="${one.writedate }"
									pattern="yyyy.MM.dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>
<jsp:include page="/WEB-INF/views/include/bottom.jsp"/>