<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@include file="../includes/header.jsp"%>
<style type="text/css">
#daybtn {
  color: red;
}
</style>
<div class="container">
<div class="row">

<%--여기서부터 작성 --%>
<div class="col-sm-12">
	<%@include file="../includes/mypageHeader.jsp"%>
	<table class="table table-bordered">
		<caption><h2 align="center">여행계획</h2></caption>
		<caption><h3 align="center"><c:out value="${calender.year}"/>년   <c:out value="${calender.month+1}"/>월</h3></caption>
		<caption>
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
			  <div id = "preYear" class="btn-group" role="group">
			    <button type="button" class="btn btn-default"><-Year</button>
			  </div>
			  <div class="btn-group" role="group">
			    <button id = "preMonth" type="button" class="btn btn-default"><-Month</button>
			  </div>
			  <div class="btn-group" role="group">
			    <button id = "nextMonth" type="button" class="btn btn-default">Month-></button>
			  </div>
			  <div class="btn-group" role="group">
			    <button id = "nextYear" type="button" class="btn btn-default">Year-></button>
			  </div>
			</div>
		</caption>
		<thead>
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="day" value="1" />
			<c:forEach var="i" begin="0" end="${calender.line-1}">
			<tr>
			<c:forEach  var="j" begin="0" end="6">
				<c:choose>
					<c:when test="${(j<calender.startDay&&i==0)||(j>calender.remainderOfLastLine-1&&i==calender.line-1&&calender.remainderOfLastLine!=0)}">
						<td></td>
					</c:when>
					<c:otherwise>
						<td>
							<table class="table table-hover">
								<%-- <thead><tr><th><c:out value="${day}"/><button id="dayBtn<c:out value="${day}"/>" value="<c:out value="${day}"/>" class="btn btn-default btn-xs pull-right" type="submit" >+</button></th></tr></thead>--%>
								<thead><tr><th>${day}<button id="dayBtn${day}" value="${day}" class="btn btn-default btn-xs pull-right" type="submit" >+</button></th></tr></thead>
								<tbody>
									<c:forEach var="has" items="${HasSchedule}" varStatus="status">
										<c:if test="${has==day}">
											<c:forEach items="${scList}" var="sclist" varStatus="status">
												<tr>
													<c:if test="${day==sclist.day}">
														<td class="info">${sclist.contentname}</td>
													</c:if>
												</tr>
											</c:forEach>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</td>
						<c:set var="day" value="${day + 1}"/>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<!-- 여기까지 -->
 
<!-- 모달창 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="Close">
        <span aria-hidden="true">&times;</span></button>
        <h4 id="modal-title" class="modal-title"></h4>
      </div>
      <div class="modal-body">
      	
      	<form action="">
	      	<c:forEach var="ckList" items="${scheduleList}" varStatus="status">
	      		<input type="checkbox" class="custom-control-input" name="addScedule" id="addScedule" value="${ckList.contentid}">
      			<label class="custom-control-label" for="addScedule">${ckList.contentname}</label>
      			<br>
	      	</c:forEach>
      	</form>
      	<!-- 몸체 -->
      </div>
      <div class="modal-footer">
      	<%-- <h1><sec:authentication property="principal.username"/></h1> --%>
      	<form action="/mypage/scheduler"  method="post">
      		<input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }">
      		<input type="hidden" name="userid" id="userid" value="<sec:authentication property="principal.username"/>"/>
      		<input type="hidden" name="modal_day" id="modal_day" value=""/>
      		<input type="hidden" name="addSchedules" id="addSchedules" value=""/>
      		<input type="hidden" name="year" id="year" value="<c:out value="${calender.year}"/>"/>
      		<input type="hidden" name="month" id="month" value="<c:out value="${calender.month}"/>"/>
      		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        	<button type="submit" class="btn btn-primary" id="saveChanges">Save changes</button>
      	</form>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--  -->

</div>
<script type="text/javascript">
	var year=<c:out value="${calender.year}"/>;
	var month= <c:out value="${calender.month}"/>;
	$("#preYear").on("click",function(){
		year--;
		self.location = "/mypage/scheduler?year="+year+"&month="+month;
	});
	$("#nextYear").on("click",function(){
		year++;
		self.location = "/mypage/scheduler?year="+year+"&month="+month;
	});
	$("#preMonth").on("click",function(){
		if(month<=0){
			year--;
			month=12;
		}
		month--;
		self.location = "/mypage/scheduler?year="+year+"&month="+month;	
	});
	$("#nextMonth").on("click",function(){
		if(month>=11){
			year++;
			month=-1;
		}
		month++;
		self.location = "/mypage/scheduler?year="+year+"&month="+month;
	});
	/* 일별 버튼 */
	for(var i=1;i<<c:out value="${day}"/>;i++){
		var day_modal;
		$("#dayBtn"+i).on("click",function(){
			/* 밸류값 받아오기 */
			day_modal=$(this).attr('value')
			/* alert("dayBtn"+day_modal); */
			$('#modal_day').val($(this).attr('value'));
			$("#modal-title").text("${calender.year}년 ${calender.month+1}월 "+day_modal+"일 스케쥴 추가");
			$('#myModal').modal("show");
		});	
	}
	$("#saveChanges").on("click",function(){
		var string="";
		$('input:checkbox[name="addScedule"]').each(function() {
			if(this.checked){//checked 처리된 항목의 값
				string+=this.value+",";
	            /* alert(this.value); */
	     	}
		 });
		$('#addSchedules').val(string);
		/* alert(string); */
	});
</script>
<%--여기까지 --%>

<%@include file="../includes/footer.jsp"%>