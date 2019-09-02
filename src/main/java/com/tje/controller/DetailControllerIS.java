package com.tje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.tje.service.DetailServiceIS;

import lombok.Setter;

@Controller
public class DetailControllerIS {
	@Setter(onMethod_ = { @Autowired })
	private DetailServiceIS detailService;
	
	// 쇼핑 리스트 출력
		@GetMapping("/detailInfo/{contentTypeId}/{contentId}")
		public ModelAndView selectShopping(@PathVariable("contentTypeId") String contentTypeId,
				@PathVariable("contentId") String contentId) {
			ModelAndView view = new ModelAndView();
			view.setViewName("detail/detailCommon");
			view.addObject("detailList", detailService.getDetailList(contentTypeId, contentId));
			return view;
		}
}
