<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/commons.jsp"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"> 

<script src="https://code.jquery.com/jquery-1.11.3.js"></script> 

<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script> 
<script> 

$(document).ready(function(){ 

    var main = $('.bxslider').bxSlider({ 

    mode: 'fade', 

    auto: true,	//자동으로 슬라이드 

    controls : true,	//좌우 화살표	

    autoControls: true,	//stop,play 

    pager:true,	//페이징 

    pause: 3000, 

    autoDelay: 0,	

    slideWidth: 1100, //이미지 박스 크기설정

    speed: 500, 

    stopAutoOnclick:true 

}); 

   

$(".bx-stop").click(function(){	// 중지버튼 눌렀을때 

    main.stopAuto(); 

    $(".bx-stop").hide(); 

    $(".bx-start").show(); 

    return false; 

}); 



$(".bx-start").click(function(){	//시작버튼 눌렀을때 

    main.startAuto(); 

    $(".bx-start").hide(); 

    $(".bx-stop").show(); 

    return false; 

}); 



  $(".bx-start").hide();	//onload시 시작버튼 숨김. 

}); 


function goback(){
	history.go(-1);
}
</script> 



</head> 

<body> 

<div class="home__slider" align="center"> 

    <div class="bxslider"> 

		<c:forEach var="imageVO" items="${imageVO}" varStatus="status">
        <div><img src="${imageVO.originimgurl}" alt=".."style="height:700px; width:900px;"></div>
		</c:forEach>

    </div> 

</div> 

<div align="center">
<button type="button" class="btn btn-danger"  onclick="goback();" >뒤로가기</button>
</div>



<%@include file="../includes/footer.jsp"%>