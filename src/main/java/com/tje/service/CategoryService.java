package com.tje.service;

import java.util.List;

import com.tje.domain.CategoryVO;

public interface CategoryService {


	public List<CategoryVO> showCategory(String contentTypeId,String areaCode,String pageno);
	public List<CategoryVO> showCategory(String contentTypeId,String areaCode);
	

}
