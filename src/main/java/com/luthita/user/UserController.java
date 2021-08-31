package com.luthita.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luthita.common.EncryptUtils;
import com.luthita.user.bo.UserBO;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/sign_up_view")
	public String signUpView(Model model) {
		model.addAttribute("viewName","user/sign_up");
		return "template/layout";
	}
	
	/**
	 * 회원가입 서브밋 - Non AJAX
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @return 로그인 화면으로 리다이렉트
	 */
	@RequestMapping("/sign_up_for_submit")
	public String signUpForSubmit(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		// 암호화
		String encrptPassword = EncryptUtils.md5(password);
		
		// DB insert
		userBO.addUser(loginId, encrptPassword, name, email);
		
		return "redirect:/user/sign_in_view"; // redirect는 @ReponseBody가 아닌 일반 @Controller에서 작동
	}
	
	@RequestMapping("/sign_in_view")
	public String signInView(Model model) {
		model.addAttribute("viewName", "user/sign_in");
		return "template/layout";
	}
	
	/**
	 * 로그아웃
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/sign_out")
	public String signOut(HttpServletRequest request){
		// 로그아웃
		HttpSession session = request.getSession();
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		
		return "redirect:/user/sign_in_view";
	}
	
	/**
	 * 
	 * 비밀번호 찾기
	 * 
	 */
	@RequestMapping("/forgot_password_view")
	public String forgotPassword(Model model) {
		
		model.addAttribute("viewName","user/forgot_password");
		return "template/layout";
		
	}
}
