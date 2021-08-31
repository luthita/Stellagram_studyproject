<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex">
	<div class="logo">
		<h1 class="textGray p-4 font-weight-bold">Stellagram</h1>
	</div>
		<%-- 로그인이 된 경우 --%>
		<c:if test="${not empty userName }">
			<div class="login-info d-flex justify-content-between align-items-center">
				<div class="input-group w-50 ml-5">
				  <input type="text" class="form-control" id="search" name="search" placeholder="search">
				  <div class="input-group-append">
				    <button type="submit" class="btn bgGray searchBtn"><i class="fa fa-search textDeepBlue" aria-hidden="true" ></i></button>
				  </div>
				</div>
				<div class="mt-5 mr-5">
					<span class="textGray"><b>${userName}</b>님 안녕하세요</span>
					<a href="/user/sign_out" class="textSkyBlue font-weight-bold ml-3">로그아웃</a>
				</div>
			</div>
		</c:if>
	
		<%-- 로그인이 안된 경우 --%>
		<c:if test="${empty userName }">
			<div class="login-info d-flex justify-content-end align-items-center">
				<div class="mt-5 mr-5">
					<a href="/user/sign_in_view" class="textGray font-weight-bold ml-3">로그인</a>
				</div>
			</div>
		</c:if>
</div>
<script>
$(document).ready(function(){
	
	$('.searchBtn').on('click', function(e) {
		var search = $('#search').val().trim();
		if(search.length < 1){
			alert("검색어를 입력해주세요");
			location.reload();
		}
		
	});
});
</script>