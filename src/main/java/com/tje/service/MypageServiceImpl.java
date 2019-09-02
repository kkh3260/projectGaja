package com.tje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.domain.CalendarVO;
import com.tje.mapper.MypageMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MypageServiceImpl implements MypageService{
	
	@Setter(onMethod_=@Autowired )
	private CalendarVO calendarVO;
	
	@Setter(onMethod_=@Autowired )
	private MypageScheduler MypageServiceImpl;
	
	@Setter(onMethod_=@Autowired )
	private MypageMapper mapper;

	@Override
	public void deleteSC(String userid,int contentid) {
		mapper.deleteSC(userid,contentid);
	}
}
