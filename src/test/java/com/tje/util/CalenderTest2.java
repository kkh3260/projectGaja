package com.tje.util;

import java.util.Calendar;

public class CalenderTest2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println("년" + cal.get(Calendar.YEAR));
		System.out.println("월" + cal.get(Calendar.MONTH) + 1);

		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.MONTH, 7);
		int startDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int remainderOfLastLine = (lastDay + startDay) % 7;
		int line = remainderOfLastLine == 0 ? (lastDay + startDay) / 7 : (lastDay + startDay) / 7 + 1;
		int day = 1;
		
		System.out.println(remainderOfLastLine);
		
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < 7; j++) {
				/*
				 * if (0 == remainderOfLastLine && i == line - 1) { System.out.print(day +
				 * "\t"); day++; }
				 */
				if ((j < startDay && i == 0) || (j > remainderOfLastLine - 1 && i == line - 1&&remainderOfLastLine!=0)) {
					System.out.print("\t");
					continue;
				}
				System.out.print(day + "\t");
				day++;
			}
			System.out.println();
		}
	}
}
