<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="jumptodetail" value="${CateList}"></c:set>
<style>
#MOVE_TOP_BTN {
    position: fixed;
    right: 2%;
    bottom: 50px;
    display: none;
    z-index: 999;
}
</style>
<script>
// 출처 : https://cofs.tistory.com/188
    $(function() {
        $(window).scroll(function() {
            if ($(this).scrollTop() > 500) {
                $('#MOVE_TOP_BTN').fadeIn();
            } else {
                $('#MOVE_TOP_BTN').fadeOut();
            }
        });
        
        $("#MOVE_TOP_BTN").click(function() {
            $('html, body').animate({
                scrollTop : 0
            }, 400);
            return false;
        });
    });
    </script>
    
<div class="container">
	<div class="row">

		<%--여기서부터 작성 --%>
		<div class="container">
<table class="table table-hover table-bordered">
<tr>
<th>항목</th>
<th>주소</th>
<th>상세주소</th>
<th>연락처</th>
<th>이미지</th>
<th>조회수</th>

</tr>
<c:forEach var="cate" items="${CateList}" varStatus="status">
<tr>
<td class="cell row"><a href="/detailInfo/${cate.contenttypeid}/${cate.contentid}">${cate.title}</a></td>
<td>${cate.addr1}</td>
<td>${cate.addr2}</td>
<td>${cate.tel}</td>
<td><img src="${cate.firstimage}"></td>
<td>${cate.readcount}</td>

</tr>
</c:forEach>
</table>

<nav>
					<ul class="pagination pagination-xs pager">


						<c:if test="${pageMaker.prev}">
							<li class="previous">
							<a href="${pageMaker.startPage -1}"> <span aria-hidden="true">&larr;</span> Older</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button  ${pageMaker.pageNo == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							 <li class="next"><a
								href="${pageMaker.endPage +1}"> Newer <span aria-hidden="true">&rarr;</span></a></li>
  
						</c:if>
						</ul>
						
						<script type="text/javascript">
						$(".pagenate_button").on("click", function(e){
							e.preventDefault();
							console.log('click');
							actionForm.find("input[name='pageNum']").val($(this).attr("href"));
							actionForm.submit();
						});
						
						
						</script>


					
</nav>



<button type="button" class="btn btn-danger" id="MOVE_TOP_BTN">TOP</button>

		</div>

		<%--여기까지 --%>
	<%@include file="./footer.jsp"%>