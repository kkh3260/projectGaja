<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<script>
	function check() {
		var regExp1 = /^[a-zA-Z0-9]{4,12}$/; // 아이디와 패스워드가 적합한지 검사할 정규식
		var regExp2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		var userName = joinform.userName.value;
		var userid = joinform.userid.value;
		var userpw = joinform.userpw.value;
		var confirm_password = joinform.confirm_password.value;
		var email = joinform.email.value;
		var phone = joinform.phone.value;
		var birth = joinform.birth.value;

		var forms = document.getElementById("joinform");

		if ((forms.userName.value == "") || (forms.userName.value.length <= 1)) {
			alert("이름을 제대로 입력해 주세요.");
			forms.userName.focus();
			return false;
		}
		if (!regExp1.test(userid)) {
			alert("아이디는 4~12자의 영문 대소문자와 숫자로만 입력");
			return false;
		}
		if (!regExp1.test(userpw)) {
			alert("패스워드는 4~12자의 영문 대소문자와 숫자로만 입력");
			return false;
		}
		if (userid.length == 0) {
			alert("아이디를 입력하세요.");
			joinform.userid.focus();
			return false;
		}
		if (userpw.length == 0) {
			alert("비밀번호를 입력하세요.");
			joinform.userpw.focus();
			return false;
		}
		if (userpw != confirm_password) {
			alert("비밀번호가 일치하지 않습니다.");
			joinform.userpw.value = "";
			joinform.confirm_password.value = "";
			joinform.userpw.focus();
			return false;
		}

		if ((email.length == 0) || (!regExp2.test(email))) {
			alert("이메일을 제대로 입력하세요.");
			joinform.email.focus();
			return false;
		}
		if ((phone.length == 0) || (forms.phone.value.length < 9)) {
			alert("전화번호를 입력하세요.");
			joinform.phone.focus();
			return false;
		}
		if ((forms.birth.value == "") || (forms.birth.value.length < 8)) {
			alert("생년월일 8자리를 입력해 주세요.");
			forms.birth.focus();
			return false;
		}
		if (idck == 0) {
			alert('아이디 중복체크를 해주세요');
			return false;
		}

		return true;
	}

	var idck = 0;
	$(function() {
		//idck 버튼을 클릭했을 때 
		$("#idck").click(function() {

			//userid 를 param.
			var userid = $("#userid").val();
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue = "${_csrf.token}";

			$.ajax({
				async : true,
				type : 'POST',
				beforeSend : function(xhr) {
					xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
				},
				data : userid,
				url : '/checkId',
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					if (data.cnt > 0) {

						alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");

						$("#userid").focus();

					} else {
						alert("사용가능한 아이디입니다.");
						$("#userpw").focus();
						//아이디가 중복하지 않으면  idck = 1 
						idck = 1;

					}
				},
				error : function() {

					alert("아이디를 입력해주세요");
				}
			});
		});
	});

	function default_checkId() {
		var csrfHeaderName = "${_csrf.headerName}";
		var csrfTokenValue = "${_csrf.token}";
		var userid = $('#userid').val();
		$.ajax({
			url : '/default_checkId',
			type : 'post',
			beforeSend : function(xhr) {
				xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
			},
			data : {
				userid : userid
			},
			success : function(data) {
				if ($.trim(data) == 0) {
					idck = 0;
				}
			},
			error : function() {
				alert("에러입니다");
			}
		});
	};
</script>
<div class="container">
	<div class="row">

		<%--여기서부터 작성 --%>

		<div class="container">
			<div class="row">
				<form onsubmit="return check()" class="form-horizontal"
					action="/member/register" method="post" id="joinform"
					name="joinform">
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }">
					<fieldset>

						<!-- Form Name -->
						<legend>
							<h1 align="center">회원가입</h1>
						</legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Name">이름</label>
							<div class="col-md-5">
								<input id="userName" name="userName" type="text"
									placeholder="username" class="form-control input-md"
									required="">


							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Name">아이디</label>
							<div class="col-md-5">
								<input id="userid" name="userid" type="text" placeholder="ID"
									class="form-control input-md" required=""
									oninput="default_checkId()"><span class="help-block">아이디는
									4~12자의 영문 대소문자와 숫자로만 입력</span> <input type="button" value="중복확인"
									id="idck"> <span id="chkMsg"></span>
							</div>

						</div>
						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="passwordinput">비밀번호</label>
							<div class="col-md-5">
								<input id="userpw" name="userpw" type="password"
									placeholder="password" class="form-control input-md"
									required=""> <span class="help-block">비밀번호는
									4~12자의 영문 대소문자와 숫자로만 입력</span>
							</div>
						</div>

						<!-- Password input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="confirm_password">비밀번호
								재확인</label>
							<div class="col-md-5">
								<input id="confirm_password" name="confirm_password"
									type="password" placeholder="Re-type password"
									class="form-control input-md" required="">

							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="email">이메일</label>
							<div class="col-md-5">
								<input id="email" name="email" type="text" placeholder="email"
									class="form-control input-md" required="">

							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="phone">휴대전화</label>
							<div class="col-md-5">
								<input id="phone" name="phone" type="text" placeholder="phone"
									class="form-control input-md" required="">

							</div>
						</div>
						<!-- Multiple Radios (inline) -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="gender">성별</label>
							<div class="col-md-4">
								<label class="radio-inline" for="gender-0"> <input
									type="radio" name="gender" value="남자" checked="checked">
									남자
								</label> <label class="radio-inline" for="gender-1"> <input
									type="radio" name="gender" value="여자"> 여자
								</label>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="birth">생년월일</label>
							<div class="col-md-5">
								<input id="birth" name="birth" type="text"
									placeholder="YYYYMMdd" class="form-control input-md"
									required="">

							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="submit"></label>
							<div class="col-md-4">
								<button id="submit" name="submit" class="btn btn-success">가입</button>
							</div>
						</div>

					</fieldset>
				</form>
			</div>
		</div>
		<%--여기까지 --%>

		<%@include file="../includes/footer.jsp"%>