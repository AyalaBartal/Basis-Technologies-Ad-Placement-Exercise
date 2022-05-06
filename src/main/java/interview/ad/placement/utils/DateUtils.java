package interview.ad.placement.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtils {
	
	private static final int CURRENT_YEAR = 22;
	
	public static Date getDate(String date) {
		String[] details = date.split("/");
		
		int month = Integer.parseInt(details[0]);
		int day = Integer.parseInt(details[1]);
		int year = Integer.parseInt(details[2]);
		
		return getDate(year, month, day);
	}
	
	public static Date getDate(int year, int month, int day) {
		if(year <= CURRENT_YEAR)
			year += 2000;
		return new GregorianCalendar(year, month-1, day).getTime();
	}
	
	public static String toString(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(calendar.get(Calendar.MONTH));
		stringBuilder.append("/");
		stringBuilder.append(calendar.get(Calendar.DAY_OF_MONTH));
		stringBuilder.append("/");
		stringBuilder.append(calendar.get(Calendar.YEAR));
		
		return stringBuilder.toString();
	}
}
