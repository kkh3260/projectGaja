package com.tje.service;

import java.util.List;

import com.tje.domain.DetailCommonVO;
import com.tje.domain.ImageVO;

public interface DetailService {

	// 디테일정보
	public List<DetailCommonVO> getDetailCommon(String contentTypeId, String contentId);

	public List<ImageVO> getDetailImage(String contentTypeId, String contentId);

	public List<Object> getDetailIntro(String contentTypeId, String contentId);
}
