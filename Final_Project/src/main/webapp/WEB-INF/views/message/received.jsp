<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container-fluid pt-3">
	<div class="row pl-3">
		<h4>${loginUser.userName }
			<small>(#${loginUser.userId }) | </small>
		</h4>
	</div>
	<div class="pt-3">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="/message/received">받은쪽지함</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="/message/sent">보낸쪽지함</a></li>
			<li class="nav-item"><a class="nav-link" href="/message/write">쪽지보내기</a></li>
		</ul>
	</div>


<div class="pt-3">
	<h5>받은쪽지함()</h5>
</div>
<div class="table-responsive-sm">
	<table class="table table-success">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>내용</th>
				<th>보낸사람</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${received }" var="vo">
			<tr> 
				<td><input type="checkbox" name="no" value="${vo.no }"/></td>
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;" style="width: 70%;">
					${fn:substring(vo.content, 0, 30)  } ...
				</td>
				<td>${vo.writer }</td>
				<td class="text-error">
					<c:choose>
						<c:when test="${vo.readDate eq null }">
							<span class="text-danger">읽지않음</span>
						</c:when>
						<c:otherwise>
							<span class="text-info">
								<fmt:formatDate value="${vo.readDate }" pattern="yyyy.MM.dd"/>
							</span>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="/WEB-INF/views/message/include/bottom.jsp" />
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />
