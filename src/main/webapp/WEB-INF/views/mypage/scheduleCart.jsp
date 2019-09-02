<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div class="container">
<div class="row">

<%--여기서부터 작성 --%>
<div class="col-sm-12">
	<%@include file="../includes/mypageHeader.jsp"%>
	<div class="col-sm-2">
	</div>
	<div class="col-sm-8">
		<table class="table">
		<caption><h3 align="center">내가 추가한 여행지</h3></caption>
		<tbody>
			<c:set var="cnt" value="1"/>
			<c:forEach var="ckList" items="${scheduleList}" varStatus="status">
				<tr>
					<td>${ckList.contentname}</td>
					<td style="width: 20%"><input type="hidden" id="contentid${cnt}" value="${ckList.contentid}"/><input class="btn btn-default" id="${cnt}" type="button" value="삭제"></td>
					<c:set var="cnt" value="${cnt+1}"/>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<%--여기까지 --%>
<script type="text/javascript">
for(var i=1;i<<c:out value="${cnt}"/>;i++){
	$("#"+i).on("click",function(){
		self.location = "/mypage/deleteSC?contentid="+$('#contentid'+$(this).attr('id')).val();
	});
}
</script>
<%@include file="../includes/footer.jsp"%>