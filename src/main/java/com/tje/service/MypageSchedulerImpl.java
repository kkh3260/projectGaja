package com.tje.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.domain.CalendarVO;
import com.tje.domain.ScheduleCartVO;
import com.tje.domain.ScheduleVO;
import com.tje.domain.SceCartVO;
import com.tje.mapper.MypageMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MypageSchedulerImpl implements MypageScheduler{
	@Setter(onMethod_=@Autowired )
	private CalendarVO calendarVO;
	
	@Setter(onMethod_=@Autowired )
	private MypageMapper mapper;
	
	@Override
	public CalendarVO calOfScheduler(int year,int month) {
		calendarVO.setYear(year);
		calendarVO.setMonth(month);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int remainderOfLastLine = (lastDay + startDay) % 7;
		int line = remainderOfLastLine == 0 ? (lastDay + startDay) / 7 : (lastDay + startDay) / 7 + 1;
		calendarVO.setLastDay(lastDay);
		calendarVO.setStartDay(startDay);
		calendarVO.setLine(line);
		calendarVO.setRemainderOfLastLine(remainderOfLastLine);
		return calendarVO;
	}
	
	@Override
	public List<ScheduleVO> ListSchedule(String username,int year,int month) {
		return mapper.getSchedule(username,year, month);
	}
	
	@Override
	public List<Integer> hasSchedule(String username,int year, int month) {
		return mapper.getHasSchedule(username,year, month);
	}
	
	@Override
	public List<ScheduleCartVO> scheduleList(String username){
		return mapper.getScheduleList(username);
	}
	
	@Override
	public void addSchedule(String username,int year, int month, int day, String schedules){
		mapper.deleteSchedule(username,year, month, day);
		try {
			String contentid[] = schedules.split(",");
			for(int i=0;i<contentid.length;i++) {
				mapper.insertSchedule(username,year, month, day, Integer.parseInt(contentid[i]));
			}
		}catch (NumberFormatException e){
		}
	}
	
	@Override
	public void addLocation(SceCartVO sceCartVO) {
		mapper.addLocation(sceCartVO);
	}
}
