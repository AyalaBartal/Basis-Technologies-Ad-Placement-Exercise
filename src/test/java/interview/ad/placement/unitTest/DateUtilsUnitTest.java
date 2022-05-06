package interview.ad.placement.unitTest;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import interview.ad.placement.utils.DateUtils;

public class DateUtilsUnitTest {
	
	@Test
	public void testStringToDate() {
		String dateSatring = "11/22/2020";
		
		Date date = DateUtils.getDate(dateSatring);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		Assert.assertEquals(10, calendar.get(Calendar.MONTH));
		Assert.assertEquals(22, calendar.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(2020, calendar.get(Calendar.YEAR));
	}
	
	@Test
	public void testStringToDateDecember() {
		String dateSatring = "12/22/2020";
		
		Date date = DateUtils.getDate(dateSatring);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		Assert.assertEquals(11, calendar.get(Calendar.MONTH));
		Assert.assertEquals(22, calendar.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(2020, calendar.get(Calendar.YEAR));
	}

}
