// 쇼핑 클릭시 모달창
$(function() {
	$("#shopping").click(function() {
		$('#myModal').modal();
			// 쇼핑에서 서울 클릭시 이벤트 
		    $("#seoul").click(function(){
				var seoul = $("#seoul").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+seoul;
		});
		 // 쇼핑에서 인천 클릭시 이벤트
			$("#incheon").click(function(){
				var incheon = $("#incheon").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+incheon;
		});
			// 쇼핑에서 대전  클릭시 이벤트
			$("#daejeon").click(function(){
				var daejeon = $("#daejeon").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+daejeon;
		});
			// 쇼핑에서 대구  클릭시 이벤트
			$("#daegu").click(function(){
				var daegu = $("#daegu").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+daegu;
		});
			// 쇼핑에서 광주 클릭시 이벤트
			$("#gwangju").click(function(){
				var gwangju = $("#gwangju").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+gwangju;
		});
			// 쇼핑에서 부산 클릭시 이벤트
			$("#busan").click(function(){
				var busan = $("#busan").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+busan;
		});
			// 쇼핑에서 울산 클릭시 이벤트
			$("#ulsan").click(function(){
				var ulsan = $("#ulsan").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+ulsan;
		});
			// 쇼핑에서 세종특별시  클릭시 이벤트
			$("#sejong").click(function(){
				var sejong = $("#sejong").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+sejong;
		});
			// 쇼핑에서 경기도  클릭시 이벤트
			$("#gyeonggi").click(function(){
				var gyeonggi = $("#gyeonggi").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+gyeonggi;
		});
			// 쇼핑에서 강원도  클릭시 이벤트
			$("#gangwon").click(function(){
				var gangwon = $("#gangwon").attr("name");
				var shopping = $("#shopping").attr("name");
				location.href="category?contentTypeId="+shopping+"&"+"areaCode="+gangwon;
		});

	});
});


// 음식점 클릭시 모달창
$(function() {
	$("#restaurant").click(function() {
		$('#myModal').modal();
		// 음식점에서 서울 클릭시 이벤트 
	    $("#seoul").click(function(){
			var seoul = $("#seoul").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+seoul;
	});
	 // 음식점에서 인천 클릭시 이벤트
		$("#incheon").click(function(){
			var incheon = $("#incheon").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+incheon;
	});
		// 음식점에서 대전  클릭시 이벤트
		$("#daejeon").click(function(){
			var daejeon = $("#daejeon").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+daejeon;
	});
		// 음식점에서 대구  클릭시 이벤트
		$("#daegu").click(function(){
			var daegu = $("#daegu").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+daegu;
	});
		// 음식점에서 광주 클릭시 이벤트
		$("#gwangju").click(function(){
			var gwangju = $("#gwangju").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+gwangju;
	});
		// 음식점에서 부산 클릭시 이벤트
		$("#busan").click(function(){
			var busan = $("#busan").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+busan;
	});
		// 음식점에서 울산 클릭시 이벤트
		$("#ulsan").click(function(){
			var ulsan = $("#ulsan").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+ulsan;
	});
		// 음식점에서 세종특별시  클릭시 이벤트
		$("#sejong").click(function(){
			var sejong = $("#sejong").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+sejong;
	});
		// 음식점에서 경기도  클릭시 이벤트
		$("#gyeonggi").click(function(){
			var gyeonggi = $("#gyeonggi").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+gyeonggi;
	});
		// 음식점에서 강원도  클릭시 이벤트
		$("#gangwon").click(function(){
			var gangwon = $("#gangwon").attr("name");
			var restaurant = $("#restaurant").attr("name");
			location.href="category?contentTypeId="+restaurant+"&"+"areaCode="+gangwon;
	});
	});
});

// 랜드마크 클릭시 모달창
$(function() {
	$("#landmark").click(function() {
		$('#myModal').modal();
		// 랜드마크에서 서울 클릭시 이벤트 
	    $("#seoul").click(function(){
			var seoul = $("#seoul").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+seoul;
	});
	 // 랜드마크에서 인천 클릭시 이벤트
		$("#incheon").click(function(){
			var incheon = $("#incheon").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+incheon;
	});
		// 랜드마크에서 대전  클릭시 이벤트
		$("#daejeon").click(function(){
			var daejeon = $("#daejeon").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+daejeon;
	});
		// 랜드마크에서 대구  클릭시 이벤트
		$("#daegu").click(function(){
			var daegu = $("#daegu").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+daegu;
	});
		// 랜드마크에서 광주 클릭시 이벤트
		$("#gwangju").click(function(){
			var gwangju = $("#gwangju").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+gwangju;
	});
		// 랜드마크에서 부산 클릭시 이벤트
		$("#busan").click(function(){
			var busan = $("#busan").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+busan;
	});
		// 랜드마크에서 울산 클릭시 이벤트
		$("#ulsan").click(function(){
			var ulsan = $("#ulsan").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+ulsan;
	});
		// 랜드마크에서 세종특별시  클릭시 이벤트
		$("#sejong").click(function(){
			var sejong = $("#sejong").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+sejong;
	});
		// 랜드마크에서 경기도  클릭시 이벤트
		$("#gyeonggi").click(function(){
			var gyeonggi = $("#gyeonggi").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+gyeonggi;
	});
		// 랜드마크에서 강원도  클릭시 이벤트
		$("#gangwon").click(function(){
			var gangwon = $("#gangwon").attr("name");
			var landmark = $("#landmark").attr("name");
			location.href="category?contentTypeId="+landmark+"&"+"areaCode="+gangwon;
	});
	});
});

// 여행코스 클릭시 모달창
$(function() {
	$("#travelCourse").click(function() {
		$('#myModal').modal();
		// 여행코스에서 서울 클릭시 이벤트 
	    $("#seoul").click(function(){
			var seoul = $("#seoul").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+seoul;
	});
	 // 여행코스에서 인천 클릭시 이벤트
		$("#incheon").click(function(){
			var incheon = $("#incheon").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+incheon;
	});
		// 여행코스에서 대전  클릭시 이벤트
		$("#daejeon").click(function(){
			var daejeon = $("#daejeon").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+daejeon;
	});
		// 여행코스에서 대구  클릭시 이벤트
		$("#daegu").click(function(){
			var daegu = $("#daegu").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+daegu;
	});
		// 여행코스에서 광주 클릭시 이벤트
		$("#gwangju").click(function(){
			var gwangju = $("#gwangju").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+gwangju;
	});
		// 여행코스에서 부산 클릭시 이벤트
		$("#busan").click(function(){
			var busan = $("#busan").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+busan;
	});
		// 여행코스에서 울산 클릭시 이벤트
		$("#ulsan").click(function(){
			var ulsan = $("#ulsan").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+ulsan;
	});
		// 여행코스에서 세종특별시  클릭시 이벤트
		$("#sejong").click(function(){
			var sejong = $("#sejong").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+sejong;
	});
		// 여행코스에서 경기도  클릭시 이벤트
		$("#gyeonggi").click(function(){
			var gyeonggi = $("#gyeonggi").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+gyeonggi;
	});
		// 여행코스에서 강원도  클릭시 이벤트
		$("#gangwon").click(function(){
			var gangwon = $("#gangwon").attr("name");
			var travelCourse = $("#travelCourse").attr("name");
			location.href="category?contentTypeId="+travelCourse+"&"+"areaCode="+gangwon;
	});
		
	});
});

// 숙박클릭시 모달창
$(function() {
	$("#hotel").click(function() {
		$('#myModal').modal();
		
		// 숙박에서 서울 클릭시 이벤트 
	    $("#seoul").click(function(){
			var seoul = $("#seoul").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+seoul;
	});
	 // 숙박에서 인천 클릭시 이벤트
		$("#incheon").click(function(){
			var incheon = $("#incheon").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+incheon;
	});
		// 숙박에서 대전  클릭시 이벤트
		$("#daejeon").click(function(){
			var daejeon = $("#daejeon").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+daejeon;
	});
		// 숙박에서 대구  클릭시 이벤트
		$("#daegu").click(function(){
			var daegu = $("#daegu").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+daegu;
	});
		// 숙박에서 광주 클릭시 이벤트
		$("#gwangju").click(function(){
			var gwangju = $("#gwangju").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+gwangju;
	});
		// 숙박에서 부산 클릭시 이벤트
		$("#busan").click(function(){
			var busan = $("#busan").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+busan;
	});
		// 숙박에서 울산 클릭시 이벤트
		$("#ulsan").click(function(){
			var ulsan = $("#ulsan").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+ulsan;
	});
		// 숙박에서 세종특별시  클릭시 이벤트
		$("#sejong").click(function(){
			var sejong = $("#sejong").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+sejong;
	});
		// 숙박에서 경기도  클릭시 이벤트
		$("#gyeonggi").click(function(){
			var gyeonggi = $("#gyeonggi").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+gyeonggi;
	});
		// 숙박에서 강원도  클릭시 이벤트
		$("#gangwon").click(function(){
			var gangwon = $("#gangwon").attr("name");
			var hotel = $("#hotel").attr("name");
			location.href="category?contentTypeId="+hotel+"&"+"areaCode="+gangwon;
	});
	});
});
