<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.tje.domain.*"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/commons.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#MOVE_TOP_BTN {
	position: fixed;
	right: 2%;
	bottom: 50px;
	display: none;
	z-index: 999;
}
</style>

<script>
	// 출처 : https://cofs.tistory.com/188
	$(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 500) {
				$('#MOVE_TOP_BTN').fadeIn();
			} else {
				$('#MOVE_TOP_BTN').fadeOut();
			}
		});

		$("#MOVE_TOP_BTN").click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 400);
			return false;
		});
	});
</script>


<div class="row"
	style="position: relative; top: 60%; left: 8%; bottom: 10%">
	<c:forEach var="cate" items="${cateVO}" varStatus="status">
		<div class="col-sm-6 col-md-4"
			style="width: 400px; height: 500px; text-align: center;">
			<div class="thumbnail">
				<img src="${cate.firstimage}" style="width: 500px; height: 300px;"
					onerror="this.src='/resources/picture/pic2.jpg'">
				<div class="caption">
					<h3>${cate.title}</h3>
					<p>${cate.addr1}</p>
					<p>
						<a href="/detailCommon?contentTypeId=${cate.contenttypeid}&contentId=${cate.contentid}"
							class="btn btn-success" role="button">자세히 보기</a>
					</p>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			function changePage() {

				var pageRowNum = $("#pagenum option:selected").val();
				location.href = "/categoryList/" + ${cate.contenttypeid}+'/' + ${cate.areacode}+'/' + pageRowNum;
			}
		</script>


	</c:forEach>
</div>

<select onchange="changePage()" name="pagenum" id="pagenum">
	<option value="20">20</option>
	<option value="40">40</option>
	<option value="60">60</option>
	<option value="80">80</option>
	<option value="100">100</option>

</select>



<%-- <div class="container">
	<div class="row">

		여기서부터 작성
		<div class="container">

			<input type="button" value="랜드마크" class="input_b" /> <input
				type="button" value="음식점" class="input_b" /> <input type="button"
				value="쇼핑" class="input_b" />


			<table class="table table-hover table-bordered">
				<c:forEach var="cateVO" items="${cateVO}" varStatus="status">
					<tr>
						<td><a
							href="/detailCommon?contentTypeId=${cateVO.contenttypeid}&contentId=${cateVO.contentid}">${cateVO.title}</a></td>
						<td>${cateVO.tel}</td>
						<td>${cateVO.addr1}</td>
						<td>${cateVO.contenttypeid}<input type="hidden"
							name="contentTypeId${status.index}"
							id="contentTypeId${status.index}" value="${cateVO.contenttypeid}">
						</td>
						<td>${cateVO.contentid}<input type="hidden"
							name="contentId${status.index}" id="contentId${status.index}"
							value="${cateVO.contentid}">
						</td>
						<td><img src="${cateVO.firstimage}"></td>
						<td>${cateVO.areacode}</td>
					</tr>




				</c:forEach>
			</table>





		</div> --%>





		<%@include file="../includes/footer.jsp"%>