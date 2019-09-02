<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<style>
#deleteblue {
	text-decoration: none;
	color: white;
}

.navbar {
	background-color: #33a74f;
}

.navbar .navbar-brand {
	color: #ffffff;
}

.navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
	color: #ffffff;
}

.navbar .navbar-text {
	color: #ffffff;
}

.navbar .navbar-text a {
	color: #ffffff;
}

.navbar .navbar-text a:hover, .navbar .navbar-text a:focus {
	color: #ffffff;
}

.navbar .navbar-nav .nav-link {
	color: #ffffff;
	border-radius: .25rem;
	margin: 0 0.25em;
}

.navbar .navbar-nav .nav-link:not (.disabled ):hover, .navbar .navbar-nav .nav-link:not
	 (.disabled ):focus {
	color: #ffffff;
}

.navbar .navbar-nav .dropdown-menu {
	background-color: #33a74f;
	border-color: #2e9146;
}

.navbar .navbar-nav .dropdown-menu .dropdown-item {
	color: #ffffff;
}

.navbar .navbar-nav .dropdown-menu .dropdown-item:hover, .navbar .navbar-nav .dropdown-menu .dropdown-item:focus,
	.navbar .navbar-nav .dropdown-menu .dropdown-item.active {
	color: #ffffff;
	background-color: #2e9146;
}

.navbar .navbar-nav .dropdown-menu .dropdown-divider {
	border-top-color: #2e9146;
}

.navbar .navbar-nav .nav-item.active .nav-link, .navbar .navbar-nav .nav-item.active .nav-link:hover,
	.navbar .navbar-nav .nav-item.active .nav-link:focus, .navbar .navbar-nav .nav-item.show .nav-link,
	.navbar .navbar-nav .nav-item.show .nav-link:hover, .navbar .navbar-nav .nav-item.show .nav-link:focus
	{
	color: #ffffff;
	background-color: #2e9146;
}

.navbar .navbar-toggle {
	border-color: #2e9146;
}

.navbar .navbar-toggle:hover, .navbar .navbar-toggle:focus {
	background-color: #2e9146;
}

.navbar .navbar-toggle .navbar-toggler-icon {
	color: #ffffff;
}

.navbar .navbar-collapse, .navbar .navbar-form {
	border-color: #ffffff;
}

.navbar .navbar-link {
	color: #ffffff;
}

.navbar .navbar-link:hover {
	color: #ffffff;
}

@media ( max-width : 575px) {
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ffffff;
	}
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ffffff;
	}
	.navbar-expand-sm .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ffffff;
		background-color: #2e9146;
	}
}

@media ( max-width : 767px) {
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ffffff;
	}
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ffffff;
	}
	.navbar-expand-md .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ffffff;
		background-color: #2e9146;
	}
}

@media ( max-width : 991px) {
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ffffff;
	}
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ffffff;
	}
	.navbar-expand-lg .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ffffff;
		background-color: #2e9146;
	}
}

@media ( max-width : 1199px) {
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item {
		color: #ffffff;
	}
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:hover,
		.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item:focus
		{
		color: #ffffff;
	}
	.navbar-expand-xl .navbar-nav .show .dropdown-menu .dropdown-item.active
		{
		color: #ffffff;
		background-color: #2e9146;
	}
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item {
	color: #ffffff;
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item:hover,
	.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item:focus {
	color: #ffffff;
}

.navbar-expand .navbar-nav .show .dropdown-menu .dropdown-item.active {
	color: #ffffff;
	background-color: #2e9146;
}
</style>
<title>GaJa</title>
<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- 제이쿼리 -->
<script type="text/javascript" src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<!--상단 메뉴바 -->
	<nav class="navbar navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">G A J A</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a id="deleteblue" href="/"><span
							class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbspHome</a></li>
					<li><a id="deleteblue" href="/mypage/myPageMain">Mypage</a></li>
					<li><a id="deleteblue" href="/board/list">Review</a></li>
					<li><a id="deleteblue" href="/mypage/scheduler?year=0&month=0">Calendar</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					
					<!-- 로그아웃 -->
					<sec:authorize access="isAuthenticated()">

						<li><a id="deleteblue" href="#"
							onclick="document.getElementById('logout-form').submit();">Logout</a></li>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<li><a id="deleteblue" href="/member/register">Join</a></li>
						<li><a id="deleteblue" href="/customLogin">Login</a></li>
					</sec:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!-- 로그아웃 폼 -->
		<form id="logout-form" action='/customLogout' method="POST">
			<input name="${_csrf.parameterName}" type="hidden"
				value="${_csrf.token}" />
		</form>

	</nav>
	<!-- 한칸 띄기 -->
	<div class="container">
		<h1>&nbsp;</h1>
	</div>

	<div class="container">
		<!-- 		<div class="row">
			<div class="col-xs-12">
				<div class="jumbotron">
					<h1>Hello, world!</h1>
				</div>
			</div>
		</div> -->

	</div>