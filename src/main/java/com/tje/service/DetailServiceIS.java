package com.tje.service;

import java.util.List;

import com.tje.domain.DetailVO;

public interface DetailServiceIS {
	public List<DetailVO> getDetailList(String contentTypeId, String contentId);
}
