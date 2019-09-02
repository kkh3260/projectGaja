package com.tje.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tje.service.MemberService;
import com.tje.domain.AuthVO;
import com.tje.domain.MemberVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//@RequestMapping("/member/*")
@Controller
@Log4j
@AllArgsConstructor
public class MemberController {
	private MemberService service;

	// 등록
	@RequestMapping(value = "/member/register", method = RequestMethod.GET)
	public void register() {
		// 입력 페이지를 보여주는 역할만 함.
	}

	@RequestMapping(value = "/member/register", method = RequestMethod.POST)
	public String register(@RequestParam(value = "auth", defaultValue = "ROLE_USER", required = false) String auth,
			MemberVO member, RedirectAttributes rttr) {

		log.info("register : " + member);
		service.register(member);

		String userid = member.getUserid();
		log.info(userid + " " + auth);
		service.register_auth(userid, auth);
		// rttr.addFlashAttribute("result", member.getUserid());
		return "redirect:/";

	}

	// 아이디 중복 검사 창
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> checkId(@RequestBody String userid) {

		int count = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();

		count = service.checkId(userid);
		map.put("cnt", count);

		return map;
	}

	@RequestMapping(value = "/default_checkId", method = RequestMethod.POST)
	public @ResponseBody String default_checkId(@ModelAttribute("member") MemberVO vo, Model model) throws Exception {
		String result = vo.getUserid();
		log.info(result);
		return String.valueOf(result);
	}

	// 조회
	@RequestMapping(value = "/member/get", method = RequestMethod.GET)
	public void get(Principal principal, Model model, Authentication auth) {
		log.info("Get get or modify");
		// log.info("사용자 정보 : " + auth);
		String userid = (String) principal.getName();
		model.addAttribute("member", service.get(userid));
	}

	// 수정
	@RequestMapping(value = "/member/modify", method = RequestMethod.GET)
	public void modify(Principal principal, Model model, Authentication auth) {
		log.info("Get get or modify");
		// log.info("사용자 정보 : " + auth);
		String userid = (String) principal.getName();
		model.addAttribute("member", service.get(userid));
	}

	@RequestMapping(value = "/member/modify", method = RequestMethod.POST)
	public String modify(Principal principal, MemberVO member, RedirectAttributes rttr, Authentication auth) {
		// memberVO.setUserid(req.getParameter("userid"));

		String userid = (String) principal.getName();
		log.info("modify : " + member);
		log.info("사용자 정보 : " + auth);
		if (service.modify(member)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member/get";
	}

	// 비밀번호 수정
	@RequestMapping(value = "/member/modifyPw", method = RequestMethod.GET)
	public void modifyPw() {
		// 입력 페이지를 보여주는 역할만 함.
	}

	@RequestMapping(value = "/member/modifyPw", method = RequestMethod.POST)
	public String modifyPw(Principal principal, MemberVO member, RedirectAttributes rttr) {

		log.info("modifyPw : " + member);
		String userid = (String) principal.getName();
		String newPw = member.getNewPw();
		if (service.modifyPw(userid, newPw)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member/get";

	}

	@RequestMapping(value = "/checkPw", method = RequestMethod.POST)
	public @ResponseBody String checkPw(@ModelAttribute("member") MemberVO vo, Principal principle, Model model) {
		log.info(vo);
		String userid = (String) principle.getName();
		String userpw = vo.getUserpw();
		log.info("controller -> checkPw : " + userpw);
		boolean result = service.checkPw(userid, userpw);
		log.info(result);
		int chpw = 0;
		if (result) {
			chpw = 1;
		}
		log.info(chpw);
		return String.valueOf(chpw);
	}

	// 삭제
	@RequestMapping(value = "/member/remove", method = RequestMethod.POST)
	public String remove(Principal principal, HttpServletRequest req, RedirectAttributes rttr, Authentication auth)
			throws Exception {
		log.info("memberController -> @PostMapping -> /remove");
		log.info("사용자 정보 : " + auth);
		String userid = (String) principal.getName();
		if (service.remove_auth(userid)) {
			rttr.addFlashAttribute("result", "success_remove_auth");
		}
		if (service.remove(userid)) {
			rttr.addFlashAttribute("result", "success_remove");
		}
		req.logout();
		return "redirect:/";
	}
}
