package com.tje.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		// Authentication auth을 파라미터로 받는 것은 => 필요한 경우 사용자의 정보를 확인할 수 있도록 하기 위해서
		log.info("access Denied : " + auth);
		// 사용자가 간단히 알아볼 수 있도록 에러 메세지를 추가함.
		model.addAttribute("msg", "Access Denied");
	}

	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error : " + error);
		log.info("logout : " + logout);

		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if (logout != null) {
			model.addAttribute("logout", "logout!!");
		}
	}

	@GetMapping("/customLogout")
	public String logoutGet(HttpServletRequest request, HttpServletResponse response) {
		log.info("★custom Logout");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				// 쿠키의 유효시간을 0으로 설정하여 만료시킨다
				cookies[i].setMaxAge(0);

				// 응답 헤더에 추가한다
				response.addCookie(cookies[i]);
			}
		}
		request.getSession().invalidate();
		return "redirect:/";
	}

	@PostMapping("/customLogout")
	public void logoutPost() {
		log.info("★post custom Logout");
	}
}
