package com.levelup.java.date;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * This java example will demonstrate truncating time in java
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/truncate-time/'>Truncate time</a>
 * 
 */
public class TruncateTime {

	private static final Logger logger = Logger.getLogger(TruncateTime.class);
	
	@Test
	public void truncate_time_in_java () {

		Calendar cal = Calendar.getInstance(); 
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		// format object
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String randomTruncatedDateFormatted = dateFormatter.format(cal.getTimeInMillis());

		logger.info("Truncated date: " + randomTruncatedDateFormatted);
		
		assertTrue(randomTruncatedDateFormatted.contains("12:00:00"));
	}

	@Test
	public void truncate_time_in_java_with_joda () {
		
		DateTime dt = new DateTime().dayOfMonth().roundFloorCopy();

		// just for formatting purposes
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String randomTruncatedDateFormatted = dateFormatter.format(dt.getMillis());

		logger.info("Truncated date: " + randomTruncatedDateFormatted);

		
		assertTrue(randomTruncatedDateFormatted.contains("12:00:00"));
	}

	@Test
	public void truncate_time_in_java_with_apache_commons () {
		
		Calendar cal = Calendar.getInstance();
		Date someRandomTruncatedDate = DateUtils.truncate(cal.getTime(), Calendar.DATE);
		
		// format object
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss z");
		String randomTruncatedDateFormatted = dateFormatter.format(someRandomTruncatedDate);
		
		logger.info("Truncated date: " + randomTruncatedDateFormatted);
		
		assertTrue(randomTruncatedDateFormatted.contains("12:00:00"));
	}

}
