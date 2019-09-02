package com.tje.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tje.domain.ScheduleCartVO;
import com.tje.domain.ScheduleVO;
import com.tje.domain.SceCartVO;

@Mapper
public interface MypageMapper {
	public List<ScheduleVO> getSchedule(@Param("userid") String userid,@Param("year")int year,@Param("month")int month);
	public List<Integer> getHasSchedule(@Param("userid") String userid,@Param("year")int year,@Param("month")int month);
	public List<ScheduleCartVO> getScheduleList(String username);
	
	public void insertSchedule(@Param("userid") String userid,@Param("year")int year,@Param("month")int month,@Param("day")int day,@Param("contentid")int contentid);
	public void deleteSchedule(@Param("userid") String userid,@Param("year")int year,@Param("month")int month,@Param("day")int day);
	public void deleteSC(@Param("userid") String userid,@Param("contentid")int contentid);
	public void addLocation(SceCartVO sceCartVO);
}
