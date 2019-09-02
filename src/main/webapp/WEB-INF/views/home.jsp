<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/resources/vendor/bootstrap/js/SelectCategoryRequestParam.js"></script>
<link rel="stylesheet" href="resources/vendor/bootstrap/css/style.css">

<div class="container">
	<div class="row">
				<div>
					<div class="container">
						<div class="row">
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0" id="shopping" name="38">
								<a class="unit-1 text-center"> <img
									src="resources/picture/shoppingmall.jpg" alt="Image" class="img-fluid" style="height:300px;">
									<div class="unit-1-text">
										<h1>쇼핑</h1>
									</div>
								</a>
							</div>
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
								
							</div> 
							
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0" id="landmark" name="12">
								<a class="unit-1 text-center"> <img
									src="resources/picture/hangang.jpg" alt="Image" class="img-fluid" style="height:300px;">
									<div class="unit-1-text">
										<h1>랜드마크</h1>
									</div>
								</a>
							</div>
							
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0" id="hotel" name="32">
								<a class="unit-1 text-center"> <img
									src="resources/picture/hotel.jpg" alt="Image" class="img-fluid" style="height:300px; ">
									<div class="unit-1-text">
										<h1>숙박</h1>
									</div>
								</a>
							</div>
							
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
								
							</div> 
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0" id="restaurant" name="39">
								<a class="unit-1 text-center"> <img
									src="resources/picture/restaurant.jpg" alt="Image" class="img-fluid" style="height:300px;">
									<div class="unit-1-text">
										<h1>음식점</h1>
									</div>
								</a>
							</div>
							<div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
								
							</div> 
						</div>
					</div>

				</div>


				<div id="navbar" class="navbar-collapse collapse">

					<!-- Modal -->
					<div class="modal fade" id="myModal">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">어디로 떠나시나요?</h4>
								</div>
								<div class="modal-body">

									<table class="table table-hover" style="font-size:15;">
										<tr>
											<td id="seoul" name="1" style="font-size:15;">서울</td> 
										</tr>

										<tr>
											<td id="incheon" name="2">인천</td>
										</tr>
										<tr>
											<td id="daejeon" name="3">대전</td>
										</tr>
										<tr>
											<td id="daegu" name="4">대구</td>
										</tr>
										<tr>
											<td id="gwangju" name="5">광주</td>
										</tr>
										<tr>
											<td id="busan" name="6">부산</td>
										</tr>
										<tr>
											<td id="ulsan" name="7">울산</td>
										</tr>
										<tr>
											<td id="sejong" name="8">세종특별시</td>
										</tr>
										<tr>
											<td id="gyeonggi" name="31">경기도</td>
										</tr>
										<tr>
											<td id="gangwon" name="32">강원도</td>
										</tr>
									</table>
								</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>
					</div>
						</div>
					</div>
				</div>
				<!-- /.nav-collapse -->
			</div>
			<!-- 	/.container-fluid -->
	</div>
	<%@include file="./includes/footer.jsp"%>