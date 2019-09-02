<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/commons.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://icono-49d6.kxcdn.com/icono.min.css">

<table align="center" width=1200px height=auto>
	<c:forEach var="detailCommonVO" items="${detailCommonVO}">
<tr>
			<th><h1>${detailCommonVO.title}</h1></th>
		</tr>
		<tr>
			<td>100건의 리뷰
				<button type="button" class="btn btn-danger" id="go-bottom">
					<i class="icono-keyboard" style="color: black;"></i>리뷰 작성 가자
				</button>
			</td>
			<td>
			<h4>
				<!-- 여행지 추가 액션 관련 추가 코드-->
					<sec:authorize access="isAuthenticated()">
					<form action="/mypage/addLocation" method="post">
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
						<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
						<!-- <a>좋아요</a>&nbsp&nbsp -->
						<input class="btn btn-info" type="submit" value="좋아요" >
						<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
						<!-- <a href="javascript:addLocation();">다이어리</a>	 -->
						<input class="btn btn-info" type="submit" value="다이어리" >
						
						<input type="hidden" name="contentid" id="contentid" value="${detailCommonVO.contentid}"/>
						<input type="hidden" name="contenttypeid" id="contenttypeid" value="${detailCommonVO.contenttypeid}"/>
						<input type="hidden" name="contentname" id="contentname" value="${detailCommonVO.title}"/>
						<input type="hidden" name="url" id="url" value="/detailCommon?contentTypeId=${detailCommonVO.contenttypeid}&contentId=${detailCommonVO.contentid}"/>
					</form>				
					</sec:authorize>
				<!-- 여행지 추가 -->
			</h4>
		</tr>
		<tr></tr>
			<td><h4>
					<span class="glyphicon glyphicon-map-marker" aria-hidden="true"
						style="color: #088A29"></span>&nbsp${detailCommonVO.addr1}&nbsp|&nbsp
					<span class="glyphicon glyphicon-earphone" aria-hidden="true"
						style="color: #088A29"></span>&nbsp전화번호${detailCommonVO.tel}&nbsp|&nbsp
					<i class="icono-display" style="color: #088A29;"></i>&nbsp| <i
						class="icono-clock" style="color: #088A29;"></i>&nbsp영업시간</td>
			</h4>

		</tr>
		<tr>
			<td></td>
			<td align="left"><h4>
					<span class="glyphicon glyphicon-camera" aria-hidden="true"
						style="color: #088A29"></span> <a
						href="/detailImage?contentTypeId=${detailCommonVO.contenttypeid}&contentId=${detailCommonVO.contentid}"><b>사진
							더보기</b></a>
				</h4></td>
		</tr>

		<tr>
			<td><img src="${detailCommonVO.firstimage}"
				style="width: 700px; height: 500px; margin-left: 50px" alt="첫번째 이미지"/ ></td>

		</tr>

	</c:forEach>
</table>

<div class="container" style="background-color: #F5F6CE" border=1>
	<c:forEach var="detailCommonVO" items="${detailCommonVO}">
		<div></div>
		<div class="col-md-4">
			<h2>
				<b>Overview</b>
			</h2>
			<br> ${detailCommonVO.overview}
		</div>
		<div class="col-md-4">
			<h2>
				<b>상세정보</b>
			</h2>
			<br>
			<h4>요리</h4>
			<br>
			<h4>주차시설</h4>
			<br>
			<h4>
				<a onclick="getInfo();">모든 세부 정보 보기</a>
			</h4>
			<br>
			<h5>식사 시간,특징,소개</h5>
			<br>
		</div>
		<div class="col-md-4">
			<h2>
				<b>위치 및 문의 정보</b>
			</h2>
			<br>
			<h3>지도</h3>

			<div id="map" style="width: 350px; height: 200px;"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bd12b65ff910bade8042ad7532156b58"></script>


			지도
			<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(${detailCommonVO.mapy}, ${detailCommonVO.mapx}),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);

</script>

			<%--페이지아래로이동 --%>
			<script type="text/javascript">
			$("#go-bottom").click(function(){
				$('html,body').scrollTop( $(document).height() );
			});
			
		
			
function getInfo(){
	
	var csrfHeaderName ="${_csrf.parameterName }";
	var csrfTokenValue="${_csrf.token }";
	
	$.ajax({
		type:"GET",
		url : "/detailIntro/"+${detailCommonVO.contenttypeid}+'/'+${detailCommonVO.contentid},		
		dataType:"json",
		async: false,
		beforeSend :function(xhr){
			xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
		},
		contentType: 'application/json charset=utf-8',
		success: function(result){
			$('#myModal').modal().on("hidden.bs.modal", function(){
			    $("#intro").html("");
			});
			
			var frist ='<TR>';
			var middle='</TD><TD>';
			var start= '<TR><TD>';
			var end='</TD></TR>';
			<%--음식점 모달창 --%>
			if(${detailCommonVO.contenttypeid}==39){
			console.log('변환 전 '+typeof result);
			console.log(result);
			var str =JSON.stringify(result.introVO); // string 으로 변환
			console.log('변환 후 '+typeof str);
			console.log(str);
			var jData =JSON.parse(str); // json객체로 변환
			console.log('변환 후 '+typeof jData);
					
				console.log(${detailCommonVO.contenttypeid});
				for(var i=0; i<jData.length;i++){
					var foodVO= jData[i];
					frist+='<TD>'+'주메&nbsp뉴: &nbsp'+middle+foodVO.firstmenu+end+
					start+'대표메뉴: &nbsp '+middle+foodVO.treatmenu+end+
					start+'포장여부: &nbsp'+middle+foodVO.packing+end+
					start+'주&nbsp차: &nbsp '+middle+foodVO.parkingfood+end+
					start+'흡연여부: &nbsp'+middle+foodVO.smoking+end+
					start+'문의전화: &nbsp '+middle+foodVO.infocenterfood+end+
					start+'영업시간: &nbsp'+middle+foodVO.opentimefood+end+
					start+'쉬는날: &nbsp'+middle+foodVO.restdatefood+end;
				}
			}
				<%--랜드마크 모달창 --%>
				if(${detailCommonVO.contenttypeid}==12){
					console.log(${detailCommonVO.contenttypeid});
					var str =JSON.stringify(result.introVO);
					var jData =JSON.parse(str);
					
					for(var i=0; i<jData.length;i++){
						var landVO= jData[i];
						frist+='<TD>'+'문의 및 안내: &nbsp'+middle+landVO.infocenter+end+
						start+'주&nbsp차: &nbsp'+middle+landVO.parking+end+
						start+'유모차대여: &nbsp'+middle+landVO.chkbabycarriage+end+
						start+'쉬는날: &nbsp'+middle+landVO.restdate+end;
						
					}
				}
				<%--쇼핑 모달창 --%>
				if(${detailCommonVO.contenttypeid}==38){
					console.log(${detailCommonVO.contenttypeid});
					var str =JSON.stringify(result.introVO);
					var jData =JSON.parse(str);
					
					for(var i=0; i<jData.length;i++){
						var shoppingVO= jData[i];
						frist+='<TD>'+'판매 품목: &nbsp'+middle+shoppingVO.saleitem+end+
						start+'문의 및 안내: &nbsp'+middle+shoppingVO.infocentershopping+end+
						start+'규모: &nbsp'+middle+shoppingVO.scaleshopping+end+
						start+'신용카드: &nbsp'+middle+shoppingVO.chkcreditcardshopping+end+
						start+'유모차대여: &nbsp'+middle+shoppingVO.chkbabycarriageshopping+end+
						start+'주차: &nbsp'+middle+shoppingVO.parkingshopping+end+
						start+'쉬는날: &nbsp'+middle+shoppingVO.restdateshopping+end;
						
					}
					
				}
				$('#intro').append(frist);
			
		},error : function(error){
			alert('ajax 실패');
		}
		
	});
};

</script>

			<br> <span class="glyphicon glyphicon-map-marker"
				aria-hidden="true"></span>&nbsp<a>${detailCommonVO.addr1} </a><br>
			<br> <span class="glyphicon glyphicon-earphone"
				aria-hidden="true"></span>&nbsp<a>전화${detailCommonVO.tel}</a>&nbsp&nbsp&nbsp&nbsp&nbsp
			<a class="btn btn-danger" data-toggle="collapse"
				href="#collapseExample" aria-expanded="false"
				aria-controls="collapseExample"> <i class="icono-display"
				style="color: black"></i>
			</a>
			<div class="collapse" id="collapseExample">
				<div class="well">${detailCommonVO.homepage}</div>
			</div>
			<br> <br>


		</div>
</div>
<div>
	<br> <br>


	</c:forEach>
</div>






<div align="center">
	<button type="button" class="btn btn-danger" onclick="goback();">뒤로가기</button>
</div>


<script>
	function goback(){
		history.go(-1);
		
	}
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">상세정보</h4>
			</div>
			<div class="modal-body">

				<table id="intro">


				</table>



			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b857badf185b076bdf5953a63b6db2cc&libraries=services,clusterer,drawing"></script>



<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<%@include file="../includes/footer.jsp"%>
