package com.tje.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tje.domain.PageDTOIS;
import com.tje.service.CategoryService;

import lombok.Setter;

@Controller
public class CategoryController {

	@Setter(onMethod_ = { @Autowired })
	private CategoryService service;
	

	// 목차데이터 가져오기
	@RequestMapping(value = "/category",method= RequestMethod.GET)
	public String getCateList(HttpServletRequest request,Model model) {
		
		String contentTypeId =request.getParameter("contentTypeId");
		String areaCode=request.getParameter("areaCode");
		String pageno=request.getParameter("pageno");
		if(pageno==null) {
			pageno="12";
		}
		
		System.out.println("@@getCateList: "+contentTypeId+","+areaCode+","+pageno);
		model.addAttribute("cateVO",this.service.showCategory(contentTypeId,areaCode,pageno));
		
		
		return "/cate/category";
	}
	
	@RequestMapping(value = "/categoryList/{contenttypeid}/{areacode}/{pageRowNum}",method= RequestMethod.GET)
	public String getCateList(@PathVariable String contenttypeid,
			@PathVariable String areacode,
			@PathVariable String pageRowNum,Model model) {
	
		
		System.out.println("@@/페이징categoryList: "+contenttypeid+","+areacode+","+pageRowNum);
		
		model.addAttribute("cateVO",this.service.showCategory(contenttypeid,areacode,pageRowNum));
		
		return "/cate/category";
	}

}
