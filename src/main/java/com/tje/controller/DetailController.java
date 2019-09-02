package com.tje.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tje.service.DetailCommentBoardService;
import com.tje.service.DetailService;

import lombok.Setter;

@Controller
public class DetailController {

	@Setter(onMethod_ = { @Autowired })
	private DetailService service;

	@Setter(onMethod_ = { @Autowired })
	private DetailCommentBoardService commentService;

	@RequestMapping(value = "/detailCommon", method = RequestMethod.GET)
	public ModelAndView getDetailCommon(HttpServletRequest request) {
		String contentTypeId = request.getParameter("contentTypeId");
		String contentId = request.getParameter("contentId");
		System.out.println("## getDetailCommon : " + contentTypeId + ", " + contentId);

		ModelAndView view = new ModelAndView();
		view.setViewName("/detail/detailCommon");
		if (this.service.getDetailCommon(contentTypeId, contentId) != null) {
			System.out.println("####컨트롤러 리스트" + this.commentService.getList(contentId));
			view.addObject("detailCommonVO", this.service.getDetailCommon(contentTypeId, contentId));
			view.addObject("commentVO", this.commentService.getList(contentId));

		}

		return view;
	}

	@RequestMapping(value = "/detailImage", method = RequestMethod.GET)
	public String getDetailImage(HttpServletRequest request, Model model) {
		String contentTypeId = request.getParameter("contentTypeId");
		String contentId = request.getParameter("contentId");
		System.out.println("## detailImage : " + contentTypeId + ", " + contentId);
		model.addAttribute("imageVO", this.service.getDetailImage(contentTypeId, contentId));
		// service.getDetailImage(ContentTypeId, ContentId)

		return "detail/images";
	}

	@ResponseBody
	@RequestMapping(value = "/detailIntro/{contenttypeid}/{contentid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> getDetailIntro(@PathVariable String contenttypeid, @PathVariable String contentid) {

		System.out.println("## detailIntro : " + contenttypeid + ", " + contentid);

		System.out.println("@@@controller 단에서 전송전 확인" + this.service.getDetailIntro(contenttypeid, contentid));
		Map<String, Object> result = new HashMap<String, Object>();

		List introVO = this.service.getDetailIntro(contenttypeid, contentid);
		result.put("code", "OK");
		result.put("introVO", introVO);

		return result;
	}
	
	

}
