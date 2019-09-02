<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<div class="container">
	<div class="row">

		<%--여기서부터 작성 --%>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Please Sign In !!</h3>
						</div>
						<div class="panel-body">
							<form role="form" method="post" action="/login">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="ID" name="username"
											type="text" autofocus>
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password"
											name="password" type="password" value="">
									</div>
									<div class="checkbox">
										<label> <input name="remember" type="checkbox">자동
											로그인
										</label>
									</div>
									<!-- Change this to a button or input when using this as a form -->
									<div>
										<input type="submit" value="로그인" class="btn btn-success">
									</div>
								</fieldset>
								<input type="hidden" name="${_csrf.parameterName }"
									value="${_csrf.token }">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%--여기까지 --%>

		<%@include file="./includes/footer.jsp"%>