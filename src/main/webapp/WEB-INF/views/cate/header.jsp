<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>GaJa</title>
<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 제이쿼리 추가 안하면 모달창 동작하지 않음 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$.getJSON("/category/landmark")
console.log

</script>

<link rel="stylesheet" href="/resources/vendor/bootstrap/css/gaja.css">
</head>

<body>
	<!--상단 메뉴바 -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
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
					<li class="active"><a href="#home">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<!-- 한칸 띄기 -->
	<div class="container">
		<h1>&nbsp;</h1>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="jumbotron">
					<h1 class="gaja">GAJA</h1>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="home"><a href="#home">Home</a></li>
						<!-- data-backdrop="static" 선택하지 않으면 못닫음.  -->
						<li><a data-toggle="modal" href="#" data-target="#myModal"
							data-backdrop="static">랜드마크</a></li>

						<li><a data-toggle="modal" href="#" data-target="#myModal"
							data-backdrop="static">음식점</a></li>

						<li><a data-toggle="modal" href="#" data-target="#myModal"
							data-backdrop="static">쇼핑</a></li>

						<li><a data-toggle="modal" href="#" data-target="#myModal"
							data-backdrop="static">숙박</a></li>

						<li><a data-toggle="modal" href="#" data-target="#myModal"
							data-backdrop="static">추천코스</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
	</div>
	


	<!-- Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">어디로 가시나요?</h4>
				</div>
				<div class="modal-body" id="select" onclick="">
				
					<input type="text" required />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">선택완료</button>
				</div>
			</div>
		</div>
	</div>