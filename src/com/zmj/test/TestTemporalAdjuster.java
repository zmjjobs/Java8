package com.zmj.test;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TestTemporalAdjuster {
	@Test
	public void test() {
		LocalDateTime withDayOfMonth = LocalDateTime.now().withDayOfMonth(10);
		System.out.println("将当前日期的日改为10="+withDayOfMonth);
		LocalDate ldt = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println("下个周日是哪天？"+ldt);//格式：2020-02-23

		LocalDate nextWorkDate = LocalDate.now().with((d) -> {
			LocalDate ld = (LocalDate)d;
			DayOfWeek dayOfWeek = (ld).getDayOfWeek();
			if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
				return ld.plusDays(3);
			} else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
				return ld.plusDays(2);
			}
			return ld.plusDays(1);
		});
		System.out.println("下一个工作日是="+nextWorkDate);//格式：2020-02-17
	}
}
