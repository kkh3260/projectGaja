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
				<h1 class="page-header">Edit</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->

		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">

					<div class="panel-heading">회원 정보 수정</div>
					<!-- /.panel-heading -->
					<div class="panel-body">

						<form role="form" action="#" method="post" id="joinform">
							<input type="hidden" name="${_csrf.parameterName }"
								value="${_csrf.token }">

							<div class="form-group">
								<label>아이디</label> <input class="form-control" name='userid'
									value='<c:out value="${member.userid}"/>' readonly="readonly">
							</div>

							<div class="form-group">
								<label>이름</label> <input class="form-control" id="userName"
									name='userName' value='<c:out value="${member.userName}"/>'>
							</div>

							<div class="form-group">
								<label>휴대전화</label> <input class="form-control" name='phone'
									id="phone" value='<c:out value="${member.phone}"/>'>
							</div>
							<div class="form-group">
								<label>이메일</label> <input class="form-control" name='email'
									id="email" value='<c:out value="${member.email}"/>'>
							</div>
							<div class="form-group">
								<label>성별</label> <input class="form-control"
									value='<c:out value="${member.gender}"/>' readonly="readonly">
							</div>
							<div class="form-group">
								<label>생년월일</label> <input class="form-control"
									value='<c:out value="${member.birth}"/>' readonly="readonly">
							</div>

							<div class="form-group">
								<label>가입일</label> <input class="form-control"
									value='<c:out value="${member.regDate}"/>' readonly="readonly">
							</div>
							<div class="form-group">
								<label>수정일</label> <input class="form-control"
									value='<c:out value="${member.updateDate}"/>'
									readonly="readonly">
							</div>

							<%-- <sec:authentication property="principal" var="pinfo" />
							<sec:authorize access="isAuthenticated()">
								<c:if test="${pinfo.username eq member.userid }">
									<button type="submit" data-oper='modify'
										class="btn btn-default">Modify</button>
									<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
								</c:if>
							</sec:authorize>
								<input type="submit" value="수정">
							--%>
							&nbsp<input type="button" value="정보수정" id="modify"
								onclick='mySubmit(1)' class="btn btn-info" /> &nbsp<input
								type="button" value="회원탈퇴" id="remove" onclick='mySubmit(2)'
								class="btn btn-danger" />
						</form>


					</div>
					<!--  end panel-body -->

				</div>
				<!--  end panel-body -->
			</div>
			<!-- end panel -->
		</div>
		<!-- /.row -->
		<script type="text/javascript">
			function mySubmit(index) {
				var formObj = $("form[role='form']");
				if (index == 1) {
					var userName = joinform.userName.value;
					var email = joinform.email.value;
					var phone = joinform.phone.value;
					var regExp2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
					var forms = document.getElementById("joinform");
					if ((forms.userName.value == "")
							|| (forms.userName.value.length <= 1)) {
						alert("이름을 제대로 입력해 주세요.");
						forms.userName.focus();
						return false;
					}
					if ((email.length == 0) || (!regExp2.test(email))) {
						alert("이메일을 제대로 입력하세요.");
						joinform.email.focus();
						return false;
					}
					if ((forms.phone.value == "")
							|| (forms.phone.value.length < 9)) {
						alert("휴대폰 번호를 확인해주세요.");
						joinform.phone.focus();
						return false;
					}

					formObj.attr("action", "/member/modify");
					formObj.attr("method", "post");
					formObj.submit();

				}
				if (index == 2) {

					formObj.attr("action", "/member/remove");
					formObj.attr("method", "post");
					formObj.submit();

				}
				/* document.myForm.submit(); */

			}
		</script>
		<!-- 경계 -->






		<%--여기까지 --%>

		<%@include file="../includes/footer.jsp"%>