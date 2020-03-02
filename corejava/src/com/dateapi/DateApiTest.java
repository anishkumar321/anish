package com.dateapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class DateApiTest {

	public static void main(String[] args)throws Exception {
	
		//q1
		LocalDate localDate=LocalDate.now();
		localDate=localDate.plusDays(10);       //q1
		System.out.println("Date : "+localDate);
		
		
		//q2
		LocalDateTime localDateTime=LocalDateTime.now();
		System.out.println("Local Time : "+localDateTime);
		if(localDateTime.getHour()<=12 && localDateTime.getMinute()<=0) {
			LocalTime time = LocalTime.parse("12:00:00");
			Duration d1=Duration.between(localDateTime.toLocalTime(), time);
			System.out.println("\nDuration : "+d1);
		}
		else {
			LocalDateTime localTime= LocalDateTime.now();
			LocalDateTime nextDay=localDateTime.plusDays(1);
			nextDay=nextDay.of(nextDay.getYear(), nextDay.getMonth(), nextDay.getDayOfMonth(), 12, 00);
			Duration d1=Duration.between(nextDay, localTime);
			System.out.println("\nDuration : "+d1);

		}
		//q3
		LocalDateTime today=LocalDateTime.now();
		LocalDateTime checkDay=LocalDateTime.of(today.getYear()+4, 2, 29, 0, 0);
		Duration d2=Duration.between(today, checkDay);
		System.out.println("\nDAYS UPTO NEXT 29th FEBRUARY :"+d2.toDays());
		
		//or
		LocalDate localDate3= LocalDate.now();
		LocalDate localDate4= LocalDate.of((localDate3.getYear()+4-(localDate3.getYear()%4)),2,29);
	    Period intervalPeriod = Period.between(localDate3, localDate4);
		System.out.println("years to leap year: " + intervalPeriod.getYears());
		System.out.println("months to leap year: " + intervalPeriod.getMonths());
		System.out.println("days to leap year: " + intervalPeriod.getDays());
		
		
		
		//q4
		ZoneId romeZone= ZoneId.of("Europe/Rome");
		LocalTime rome = LocalTime.now(romeZone);
		System.out.println("\nROME/EURPOE :"+rome);
		ZoneId australiaZone= ZoneId.of("Australia/Sydney");
		LocalTime aus = LocalTime.now(australiaZone);
		System.out.println("AUSTRALIA :"+aus);
		ZoneId malaZone= ZoneId.of("Asia/Kuching");
		LocalTime malaysia = LocalTime.now(malaZone);
		System.out.println("MALAYSIA :"+malaysia);
		
		
		//q5
		DateTimeFormatter italianFormatter=DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
				LocalDate date1 = LocalDate.now();
				String formattedDate_1 = date1.format(italianFormatter); //18. marzo2014
				System.out.println("\nITALIAN DATE :"+formattedDate_1);
				DateTimeFormatter frenchFormatter=DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.FRENCH);
				LocalDate date2 = LocalDate.now();
				String formattedDate_2 = date2.format(frenchFormatter);
				System.out.println("ITALIAN DATE :"+formattedDate_2);
				DateTimeFormatter englishFormatter=DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ENGLISH);
				LocalDate date3 = LocalDate.now();
				String formattedDate_3 = date3.format(englishFormatter);
				System.out.println("ENGLISH DATE :"+formattedDate_3);

		
		
		//q6
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate day1=LocalDate.now();
		String formatDay1=day1.format(formatter1);
		System.out.println("\n"+formatDay1);
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate day2=LocalDate.now();
		String formatDay2=day2.format(formatter2);
		System.out.println(formatDay2);
		
	
	
		//q7
		int  count=0;
		LocalDate firstDayOfYear=LocalDate.of(2019, 12, 31);
		LocalDate nextSunday= firstDayOfYear.with(next(DayOfWeek.SUNDAY));
		while(nextSunday.getYear()==(firstDayOfYear.getYear()+1)) {
			LocalDate check=nextSunday.with(next(DayOfWeek.SUNDAY));
			nextSunday=check;
			count++;
		}
		System.out.println("THE NO OF SUNDAYS IN YEAR :"+firstDayOfYear.getYear()+" ="+(count+1));
		
		
		
		//q8
		
	}
	
}


