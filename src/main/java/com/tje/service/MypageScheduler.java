package com.tje.service;

import java.util.List;

import com.tje.domain.CalendarVO;
import com.tje.domain.SceCartVO;
import com.tje.domain.ScheduleCartVO;
import com.tje.domain.ScheduleVO;

public interface MypageScheduler {
	public CalendarVO calOfScheduler(int year,int month);
	public List<ScheduleVO> ListSchedule(String username, int year, int month);
	public List<Integer> hasSchedule(String username, int year, int month);
	public List<ScheduleCartVO> scheduleList(String username);
	public void addSchedule(String username,int year, int month, int day, String schedules);
	public void addLocation(SceCartVO sceCartVO);
}
