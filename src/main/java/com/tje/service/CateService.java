package com.tje.service;

import java.util.List;

import com.tje.domain.CateVO;

public interface CateService {

	public List<CateVO> showCategory(String contentTypeId, String areaCode, String pageNo, String numOfRows, String totalCount);
	
}
