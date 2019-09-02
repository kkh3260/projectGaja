package com.tje.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tje.domain.CateVO;
@Service
public class CateServiceImple implements CateService {

	@Override
	public List<CateVO> showCategory(String contentTypeId, String areaCode, String pageno, String numOfRows,
			String totalCount) {
		
		XMLParserIS xml = new XMLParserIS();
		String mainurl = xml.setCateURL(contentTypeId, areaCode, pageno, numOfRows, totalCount);
		List cateVO = xml.parserXML(mainurl);
		
		
		return cateVO;
	}

}
