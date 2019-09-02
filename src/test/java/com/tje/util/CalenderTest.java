package com.tje.util;

import java.util.Calendar;

public class CalenderTest {
	static Calendar cal = Calendar.getInstance();

	public static void main(String[] args) {
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.YEAR, 2019);
		// month는 -1해야함
		cal.set(Calendar.MONTH, 5);
		int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		int remainderOfLastLine = (lastDay + startDay) % 7;
		
		int line = remainderOfLastLine == 0 ? (lastDay + startDay) / 7 : (lastDay + startDay) / 7 + 1;
		//int reminderOfLastLine = remainder == 0 ? 0 : 7 - remainder;

		System.out.println(startDay);
		System.out.println(lastDay);
		System.out.println(line);
		System.out.println(remainderOfLastLine);
		//System.out.println(reminderOfLastLine);

		for (int i = -startDay; i <= lastDay; i++) {
			if (i > 0) {
				System.out.print(i);
			}
			System.out.print("\t");
			if ((i + startDay) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		
		int day=1;
		for (int i = 0; i < line; i++) {
			for(int j=0;j<7;j++) {
				if((j<startDay&&i==0)||(j>remainderOfLastLine-1&&i==line-1)) {
					System.out.print("\t");
					//System.out.println();
					//System.out.println("체크 "+j);
					continue;
				}
				System.out.print(day);
				System.out.print("\t");
				day++;
			}
			System.out.println();
		}
	}
}
