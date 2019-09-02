package com.tje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tje.domain.PageDTOIS;
import com.tje.service.CateService;

import lombok.Setter;

@Controller
public class MainController {

	@Setter(onMethod_ = { @Autowired })
	private CateService cateservice;

	
	  // �눥�븨 �럹�씠吏� 2遺��꽣 異쒕젰
	  /*
	 @GetMapping(
	 "/shopping/{contentTypeId}/{areaCode}/{pageNo}/{numOfRows}/{totalCount}")
	  public ModelAndView selectShoppingPage(@PathVariable("contentTypeId") String
	  contentTypeId,
	  
	  @PathVariable("areaCode") String areaCode,
	  
	  @PathVariable("pageNo") int pageNo,
	  
	  @PathVariable("numOfRows") int numOfRows,
	  
	  @PathVariable("totalCount") int totalCount) { ModelAndView view = new
	  ModelAndView(); view.setViewName("includes/navigation");
	  view.addObject("CateList", cateservice.getCateList(contentTypeId, areaCode,
	  pageNo, numOfRows, totalCount)); return view; }
	  
	  // �쓬�떇 �럹�씠吏� 2遺��꽣 異쒕젰
	  
	  @GetMapping(
	  "/restaurant/{contentTypeId}/{areaCode}/{pageNo}/{numOfRows}/{totalCount}")
	  public ModelAndView selectRestaurant(@PathVariable("contentTypeId") String
	  contentTypeId,
	  
	  @PathVariable("areaCode") String areaCode,
	  
	  @PathVariable("pageNo") int pageNo,
	  
	  @PathVariable("numOfRows") int numOfRows,
	  
	  @PathVariable("totalCount") int totalCount) { ModelAndView view = new
	  ModelAndView(); view.setViewName("includes/navigation");
	  view.addObject("CateList", cateservice.getCateList(contentTypeId, areaCode,
	  pageNo, numOfRows, totalCount)); return view; }
	  
	  // �옖�뱶留덊겕 由ъ뒪�듃 異쒕젰
	  
	  @GetMapping(
	  "/landmark/{contentTypeId}/{areaCode}/{pageNo}/{numOfRows}/{totalCount}")
	  public ModelAndView selectLandmark(@PathVariable("contentTypeId") String
	  contentTypeId,
	  
	  @PathVariable("areaCode") String areaCode,
	  
	  @PathVariable("pageNo") int pageNo,
	  
	  @PathVariable("numOfRows") int numOfRows,
	  
	 * @PathVariable("totalCount") int totalCount) { ModelAndView view = new
	 * ModelAndView(); view.setViewName("includes/navigation");
	 * view.addObject("CateList", cateservice.getCateList(contentTypeId, areaCode,
	 * pageNo, numOfRows, totalCount)); return view; }
	 */

	// �닕諛� 由ъ뒪�듃 異쒕젰
	@RequestMapping({"/hotel/{contentTypeId}/{areaCode}", "/hotel/{contentTypeId}/{areaCode}/{pageNo}/{numOfRows}/{totalCount}"})
	public ModelAndView selectHotel(@RequestParam("contentTypeId") String contentTypeId,
			@RequestParam("areaCode") String areaCode, 
			@RequestParam(value="pageNo", required = false, defaultValue = "1") String pageNo,
			@RequestParam(value="numOfRows", required = false, defaultValue = "12") String numOfRows,
			@RequestParam(value="totalCount", required = false, defaultValue = "100") String totalCount) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("includes/navigation");
		view.addObject("CateList", cateservice.showCategory(contentTypeId, areaCode, pageNo, numOfRows, totalCount));
		view.addObject("pageMaker", new PageDTOIS(Integer.parseInt(pageNo), Integer.parseInt(numOfRows), Integer.parseInt(totalCount)));
		return view;
		
	} 

	/*
	 * // �뿬�뻾肄붿뒪 由ъ뒪�듃 異쒕젰travelCourse
	 * 
	 * @RequestMapping({"/concert/",
	 * "/travelCourse/{contentTypeId}/{areaCode}/{pageNo}/{numOfRows}/{totalCount}"}
	 * ) public ModelAndView travelCourse(@RequestParam("contentTypeId") String
	 * contentTypeId,
	 * 
	 * @RequestParam("areaCode") String areaCode,
	 * 
	 * @RequestParam(value="pageno", required = false, defaultValue = "1") String
	 * pageno,
	 * 
	 * @RequestParam(value="numOfRows", required = false, defaultValue = "12")
	 * String numOfRows,
	 * 
	 * @RequestParam(value="totalCount", required = false, defaultValue = "30")
	 * String totalCount) { ModelAndView view = new ModelAndView();
	 * view.setViewName("includes/navigation"); view.addObject("CateList",
	 * cateservice.showCategory(contentTypeId, areaCode, pageno, numOfRows,
	 * totalCount)); return view; }
	 */
}

//@RequestMapping(value = "/category", method=RequestMethod.GET)
//public ModelAndView selectCate(
//@RequestParam("areaCode") String areaCode) {
//	
//	ModelAndView view = new ModelAndView();
//	view.setViewName("includes/navigation");
//	view.addObject("hotelList",hotelservice.getHotelList(areaCode));
//
//	return view;}

//@ResponseBody
//public Map selectCate(
//		@RequestParam("contentTypeId") String contentTypeId,
//		@RequestParam("areaCode") String areaCode, Model model) {
//	    
//	List<HotelVO> hotelList = hotelservice.getHotelList(contentTypeId, areaCode);
//	
//	Map list = new HashMap();
//	list.put("result", Boolean.TRUE);
//	list.put("data", areaList); // �굹以묒뿉 ajax�뿉�꽌 留ㅺ컻蹂��닔�쓽 �엯�젰 媛믪쑝濡� �궗�슜�븯寃� �맂�떎. 
//	    // System.out.println("�뜲�씠�꽣媛� 異쒕젰�릺怨� �엳�쓬.");
//        
//        // System.out.println(model);
//        return list;	
//}

//@GetMapping(value = "/{contentTypeId}/{areaCode}")
//public String selectArea(
//		@PathVariable("contentTypeId") String contentTypeId, 
//		@PathVariable("areaCode") String areaCode,
//		Model model) {
//	    System.out.println("�뜲�씠�꽣媛� 異쒕젰�릺怨� �엳�쓬.");
//        
//        System.out.println(model);
//        return "includes/category";		
//}
//@GetMapping(value = "/")
// selectArea�쓽 url�씠 category
// get�� �겢�씪�씠�뼵�듃濡� 遺��꽣 �뱾�뼱�삩 �슂泥� 諛⑹떇�쓣 紐낆떆�빐 二쇨퀬 �엳�쓬.
//@RequestMapping(value = "/category", method=RequestMethod.GET)
//@ResponseBody
//public Map selectArea() {
//	
//	List<HomeVO> areaList = homeservice.getAddress();
//	Map list = new HashMap();
//	list.put("result", Boolean.TRUE);
//	list.put("data", areaList); // �굹以묒뿉 ajax�뿉�꽌 留ㅺ컻蹂��닔�쓽 �엯�젰 媛믪쑝濡� �궗�슜�븯寃� �맂�떎. 
//	    // System.out.println("�뜲�씠�꽣媛� 異쒕젰�릺怨� �엳�쓬.");
//        
//        // System.out.println(model);
//        return list;		
//        
//}
