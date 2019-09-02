package com.tje.controller;

import java.security.Principal;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tje.domain.CalendarVO;
import com.tje.domain.MemberVO;
import com.tje.domain.SceCartVO;
import com.tje.service.MypageScheduler;
import com.tje.service.MypageService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/mypage/*")
@AllArgsConstructor
//@SessionAttributes("member")
public class MyPageController {
	private MypageService service;
	
	private SceCartVO sceCartVO;

	private CalendarVO calendarVO;

	private MypageScheduler MypageScheduler;

	@GetMapping("/scheduler")
	@PreAuthorize("isAuthenticated()")
	public void scheduler(@RequestParam("year") int year, int month, Model model, Principal principal) {
		String username = (String)principal.getName();
		if (year == 0 || month == 0) {
			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH);
		}
		model.addAttribute("calender", MypageScheduler.calOfScheduler(year, month));
		model.addAttribute("scList", MypageScheduler.ListSchedule(username,year, month));
		model.addAttribute("HasSchedule", MypageScheduler.hasSchedule(username,year, month));
		model.addAttribute("scheduleList", MypageScheduler.scheduleList(username));
	}

	@PostMapping("/scheduler")
	@PreAuthorize("isAuthenticated()")
	public String scheduler(HttpServletRequest request, Model model, Principal principal) {
		String username = (String)principal.getName();
		String schedules = request.getParameter("addSchedules");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("modal_day"));
		// 스트링 값으로 받아온 여행지의 contentNO의 문자열을 보내줌
		MypageScheduler.addSchedule(username,year, month, day, schedules);
		model.addAttribute("calender", MypageScheduler.calOfScheduler(year, month));
		model.addAttribute("scList", MypageScheduler.ListSchedule(username,year, month));
		
		model.addAttribute("HasSchedule", MypageScheduler.hasSchedule(username,year, month));
		
		model.addAttribute("scheduleList", MypageScheduler.scheduleList(username));
		return "redirect:/mypage/scheduler?year=" + year + "&month=" + month;
	}
	@GetMapping("/myPageMain")
	@PreAuthorize("isAuthenticated()")
	public void myPageMain() {

	}

	@GetMapping("/scheduleCart")
	@PreAuthorize("isAuthenticated()")
	public void scheduleCart(Model model, Principal principal) {
		String username = (String)principal.getName();
		model.addAttribute("scheduleList", MypageScheduler.scheduleList(username));
	}

	@GetMapping("/deleteSC")
	@PreAuthorize("isAuthenticated()")
	public String deleteSC(@RequestParam("contentid") int contentid, Principal principal) {
		String username = (String)principal.getName();
		service.deleteSC(username,contentid);
		return "redirect:/mypage/scheduleCart";
	}
	
	@PostMapping("/addLocation")
	public String addLocation(HttpServletRequest request, Model model, Principal principal) {
		sceCartVO.setUserid((String)principal.getName());
		sceCartVO.setContentid(Integer.parseInt(request.getParameter("contentid")));
		sceCartVO.setContenttypeid(Integer.parseInt(request.getParameter("contenttypeid")));
		sceCartVO.setContentname(request.getParameter("contentname"));
		MypageScheduler.addLocation(sceCartVO);
		return "redirect:"+request.getParameter("url");
	}
}
