package com.tje.domain;

import lombok.Data;

@Data
public class CateVO {
	// 관광API 데이터 관련 VO
	private String resultCode;
	private String resultMsg;
	private String contentid;
	private String contenttypeid;
	private String firstimage;
	private String addr1;
	private String addr2;
	private String areacode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String readcount;
	private String tel;
	private String title;
	private String sigungucode;
	
	private String pageNo;
	private String numOfRows;
	private String totalCount;
}
