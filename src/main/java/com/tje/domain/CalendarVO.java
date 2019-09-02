package com.tje.domain;

import lombok.Data;

@Data
public class CalendarVO {
	//private Date today;
	private int year;
	private int month;
	private int startDay;
	private int lastDay;
	private int remainderOfLastLine;
	private int line;
}
