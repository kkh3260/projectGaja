<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@include file="../includes/header.jsp"%>

<div class="container">
	<div class="row">

		<%--여기서부터 작성 --%>

		<div class="container">
			<div class="row">
				<form name="modifyPw" id="modifyPw" role="form"
					class="form-horizontal" action="/member/modifyPw" method="post">
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }">
					<fieldset>

						<!-- Form Name -->
						<legend>
							<h4 align="center">비밀번호 변경</h4>
						</legend>
						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="passwordinput">현재
								비밀번호</label>
							<div class="col-md-4">
								<input id="userpw" name="userpw" type="password"
									placeholder="Password" class="form-control input-md"
									required="">
							</div>

						</div>
						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">
								<input type="button" value="인증" onclick='mySubmit(1)'
									class="btn btn-success" />
							</div>
						</div>
						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="passwordinput">새
								비밀번호</label>
							<div class="col-md-4">
								<input id="newPw" name="newPw" type="password"
									placeholder="New_password" class="form-control input-md"
									required=""> <span class="help-block">패스워드는
									4~12자의 영문 대소문자와 숫자로만 입력</span>
							</div>
						</div>

						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="confirm_password">새
								비밀번호 재확인</label>
							<div class="col-md-4">
								<input id="confirm_newPw" name="confirm_newPw" type="password"
									placeholder="Re-type password" class="form-control input-md"
									required="">

							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label"></label>
							<div class="col-md-4">

								<input type="button" value="완료" onclick='mySubmit(2)'
									class="btn btn-success" />
							</div>
						</div>

					</fieldset>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			var chpw = false;
			function mySubmit(index) {

				var formObj = $("form[role='form']");

				if (index == 1) {
					var csrfHeaderName = "${_csrf.headerName}";
					var csrfTokenValue = "${_csrf.token}";
					var userpw = $('#userpw').val();
					$.ajax({
						url : '/checkPw',
						type : 'post',
						beforeSend : function(xhr) {
							xhr
									.setRequestHeader(csrfHeaderName,
											csrfTokenValue);
						},
						data : {
							userpw : userpw
						},
						success : function(data) {
							if ($.trim(data) == 1) {
								chpw = true;
								alert("인증 완료");
							} else {
								alert("비밀번호가 일치하지 않습니다");
							}
						},
						error : function() {
							alert("에러입니다");
						}
					});
				}
				if (index == 2) {
					var newPw = modifyPw.newPw.value;
					var confirm_newPw = modifyPw.confirm_newPw.value;
					var regExp1 = /^[a-zA-Z0-9]{4,12}$/; // 아이디와 패스워드가 적합한지 검사할 정규식

					if (newPw != confirm_newPw) {
						alert("새 비밀번호가 일치하지 않습니다.");
						modifyPw.newPw.value = "";
						modifyPw.confirm_newPw.value = "";
						modifyPw.newPw.focus();
						return false;
					}
					if (!regExp1.test(newPw)) {
						alert("패스워드는 4~12자의 영문 대소문자와 숫자로만 입력");
						return false;
					}
					if (!chpw) {
						alert('현재 비밀번호 인증을 해주세요' + chpw);
						return false;
					}
					formObj.attr("action", "/member/modifyPw");
					formObj.attr("method", "post");
					formObj.submit();

				}
				/* 	document.myForm.submit(); */
			}
		</script>

		<!-- 경계 -->

		<%--여기까지 --%>

		<%@include file="../includes/footer.jsp"%>