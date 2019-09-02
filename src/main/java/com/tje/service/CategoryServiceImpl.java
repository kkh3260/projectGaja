package com.tje.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tje.domain.CategoryVO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<CategoryVO> showCategory(String contentTypeId, String areaCode,String pageRowNum) {
		
		XMLParser xml= new XMLParser();
		String mainURL=xml.setCateURL(contentTypeId, areaCode, pageRowNum); 
		List cateVO=xml.parserXML(mainURL); 
		return cateVO; 
	}

	@Override
	public List<CategoryVO> showCategory(String contentTypeId, String areaCode) {
		XMLParser xml= new XMLParser();
		String pageRowNum ="12";
		String mainURL=xml.setCateURL(contentTypeId, areaCode,pageRowNum); 
		List cateVO=xml.parserXML(mainURL); 
		return  cateVO;
	}

	
}
