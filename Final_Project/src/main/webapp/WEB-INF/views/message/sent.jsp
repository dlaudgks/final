<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container-fluid pt-3">
	<div class="row pl-3">
		<h4>${loginUser.userName }
			<small>(#${loginUser.userId }) | </small>
		</h4>
	</div>
	<div class="pt-3">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link " href="/message/received">받은쪽지함</a>
			</li>
			<li class="nav-item"><a class="nav-link active" href="/message/sent">보낸쪽지함</a></li>
			<li class="nav-item"><a class="nav-link" href="/message/write">쪽지보내기</a></li>
		</ul>
	</div>


<div class="pt-3">
	<h5>보낸쪽지함</h5>
</div>
<div class="table-responsive-sm">
	<table class="table table-warning">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>내용</th>
				<th>받을사람</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="checkbox" /></td>
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
				스프링 프레임워크(영어: Spring Framework)는 자바 플랫폼을 위한 오픈 소스 애......
				</td>
				<td>관리자(admin)</td>
				<td class="text-error">읽지않음</td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
				제어 반전(IoC: Inversion of Control) 컨테이너는 스프링의 가장 중요하고 핵심적.....
				</td>
				<td>관리자(admin)</td>
				<td class="text-error">읽음</td>
			</tr>
		</tbody>
	</table>
</div>




<jsp:include page="/WEB-INF/views/message/include/bottom.jsp" />
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />
