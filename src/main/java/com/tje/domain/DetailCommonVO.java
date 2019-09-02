package com.tje.domain;

import lombok.Data;

@Data
public class DetailCommonVO {
	// 공통정보
	private String contentid;
	private String contenttypeid;
	private String addr1; // 주소
	private String addr2; // 상세주소
	private String mapx; // GPS X좌표
	private String mapy; //  GPS Y좌표
	private String overview; // 개요
	private String homepage; // 홈페이지 주소
	private String tel; //전화번호
	private String title;
	private String firstimage; // 대표이미지(원본)
	private String firstimage2; // 대표이미지(썸네일)
	//private String areacode; // 지역코드
	//private String sigungucode; // 시군구코드
}
