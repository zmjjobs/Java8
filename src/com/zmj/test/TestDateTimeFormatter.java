package com.zmj.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TestDateTimeFormatter {
	@Test
	public void test() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(dtf.format(LocalDateTime.now()));//格式：2020-02-16 23:09:53

		LocalDateTime parse = LocalDateTime.now().parse("2020-02-16 23:09:53",dtf);
		System.out.println(parse);//格式：2020-02-16T23:09:53

		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("------所有的时区----");
		zoneIds.forEach(System.out::println);

		LocalDateTime hongKongDateTime = LocalDateTime.now(ZoneId.of("Asia/Hong_Kong"));
		System.out.println("香港日期时间="+hongKongDateTime);//格式：2020-02-16T23:30:03.194

		ZonedDateTime beijingDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai")).atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(beijingDateTime);//格式：2020-02-16T23:30:03.194+08:00[Asia/Shanghai]
	}
}
