<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="../includes/header.jsp"%>
<div class="container">
	<div class="row">

		<%--여기서부터 작성 --%>

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h1 class="page-header">Info</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">

					<div class="panel-heading">상세 회원 정보</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<div class="form-group">
							<label>아이디</label> <input class="form-control" name='userpw'
								value='<c:out value="${member.userid}"/>' readonly="readonly">
						</div>
						<div class="form-group">
							<label>비밀번호</label>
							<form action="/member/modifyPw" method="get">
								<input type="submit" value="비밀번호 변경">
							</form>
						</div>
						<div class="form-group">
							<label>이름</label> <input class="form-control" name='userName'
								value='<c:out value="${member.userName}"/>' readonly="readonly">
						</div>

						<div class="form-group">
							<label>휴대전화</label> <input class="form-control" name='phone'
								value='<c:out value="${member.phone}"/>' readonly="readonly">
						</div>
						<div class="form-group">
							<label>이메일</label> <input class="form-control" name='email'
								value='<c:out value="${member.email}"/>' readonly="readonly">
						</div>
						<div class="form-group">
							<label>성별</label> <input class="form-control" name='gender'
								value='<c:out value="${member.gender}"/>' readonly="readonly">
						</div>
						<div class="form-group">
							<label>생년월일</label> <input class="form-control" name='birth'
								value='<c:out value="${member.birth}"/>' readonly="readonly">
						</div>

						<div class="form-group">
							<label>가입일</label> <input class="form-control" name='regDate'
								value='<c:out value="${member.regDate}"/>' readonly="readonly">
						</div>
						<div class="form-group">
							<label>수정일</label> <input class="form-control" name='updateDate'
								value='<c:out value="${member.updateDate}"/>'
								readonly="readonly">
						</div>



						<sec:authentication property="principal" var="pinfo" />
						<sec:authorize access="isAuthenticated()">
							<c:if test="${pinfo.username eq member.userid}">
								<a href="/member/modify">회원정보 수정하기</a>

							</c:if>
						</sec:authorize>

					</div>
					<!--  end panel-body -->

				</div>
				<!--  end panel-body -->
			</div>
			<!-- end panel -->
		</div>
		<!-- /.row -->

		<%--여기까지 --%>

		<%@include file="../includes/footer.jsp"%>