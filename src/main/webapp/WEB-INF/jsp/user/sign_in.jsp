<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="d-flex justify-content-center align-items-center">
	<div class="image-box m-5">
		<img id="bannerImage" alt="sign_in_image" src="/static/images/banner1.jpg" width="300px" height="400px">
	
	</div>
	<div class="login-box m-5">
		<h1 class="textDeepBlue font-weight-bold">Stellagram</h1>
		
		<form id="loginForm" method="post" action="/user/sign_in">
			<div class="input-group mb-3">
				<%-- input-group-prepend : input 앞에 ID 부분을 회색으로 붙인다. --%>
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-user-o" aria-hidden="true"></i></span>
				</div>
				<input type="text" class="form-control" id="loginId" name="loginId">
			</div>
			
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fa fa-key" aria-hidden="true"></i></span>
				</div>
				<input type="password" class="form-control" id="password" name="password">
			</div>
			
			<a href="/user/forgot_password_view" class="textBlue pb-3">Forgotten password?</a>
			<hr>
			<input type="submit" class="btn btn-primary btn-block" value="로그인">
			<a href="/user/sign_up_view" class="btn btn-dark btn-block">회원가입</a>
		</form>
	</div>
</div>

<script>
	$(document).ready(function(){
		$('#loginForm').submit(function(e){
			e.preventDefault();
			
			// validation
			let loginId = $('#loginId').val().trim();
			if(loginId == ''){
				alert("아이디를 입력하세요");
				return;
			}
			
			let password = $('#password').val();
			let confirmPassword = $('#confirmPassword').val();
			if(password == '' || confirmPassword == ''){
				alert("비밀번호를 입력하세요.");
				return;
			}
			
			// AJAX로 submit
			let url = $(this).attr('action');
			let params = $(this).serialize();
			
			$.post(url, params).done(function(data){
				if(data.result == 'success'){
					location.href ="/timeline/timeline_view";
				} else{
					alert("로그인에 실패했습니다. 다시 시도해주세요");
				}
			});
		});
		
		let bannerList = ["/static/images/banner1.jpg", "/static/images/banner2.jpg", "/static/images/banner3.jpg", "/static/images/banner4.jpg"];
        let currentImageIndex = 0;
        setInterval(function() {
            $("#bannerImage").attr("src", bannerList[currentImageIndex]);
            currentImageIndex++;

            if(currentImageIndex == bannerList.length) {
                currentImageIndex = 0;
            }
        }, 3000); 
	});
</script>