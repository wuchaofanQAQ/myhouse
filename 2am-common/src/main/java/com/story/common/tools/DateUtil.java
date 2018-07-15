package com.story.common.tools;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

	public static final String STANDARD_DATE_FORMAT = "yyyy-MM-dd";

	public static final String STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String STANDARD_SHORT_DATE_FORMAT = "MM-dd";

	public static final String STANDARD_SHORT_TIME_FORMAT = "HH:mm";

	public static final long SECOND = 1000;

	public static final long MINUTE = SECOND * 60;

	public static final long HOUR = MINUTE * 60;

	public static final long DAY = HOUR * 24;

	public static final long WEEK = DAY * 7;

	public static final long YEAR = DAY * 365;

	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public static int compare(Date d1, Date d2) {
		return d1.compareTo(d2);
	}

	public static int compare(Date date) {
		return date.compareTo(new Date());
	}

	private static SimpleDateFormat getDefaultDateFormat() {
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	}

	private static SimpleDateFormat getDefaultDateTimeFormat() {
		return new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
	}

	private static SimpleDateFormat getStandardDateFormat() {
		return new SimpleDateFormat(STANDARD_DATE_FORMAT);
	}

	private static SimpleDateFormat getStandardDateTimeFormat() {
		return new SimpleDateFormat(STANDARD_DATETIME_FORMAT);
	}

	/**
	 * [得到当前时间，格式2013-09-20 00:00:00]
	 * @return
	 */
	public static Date getCurrentDate() {
		String date = toStandardDate(new Date());
		return toStandardDate(date);
	}

	public static Date toDefaultDate(String source) {
		if (source == null)
			return null;
		try {
			return getDefaultDateFormat().parse(source);
		} catch (ParseException e) {
			logger.error("String cast to date,argument: ".concat(source).concat(e.getMessage()));
		}
		return null;
	}

	public static Date toStandardDate(String source) {
		if (source == null)
			return null;
		try {
			return getStandardDateFormat().parse(source);
		} catch (ParseException e) {
			logger.error("String cast to date,argument: ".concat(source).concat(e.getMessage()));
		}
		return null;
	}

	public static Date toDefaultDateTime(String source) {
		if (source == null)
			return null;
		try {
			return getDefaultDateTimeFormat().parse(source);
		} catch (ParseException e) {
			logger.error("String cast to date,argument: ".concat(source).concat(e.getMessage()));
		}
		return null;
	}


	public static Date toStandardDateTime(String source) {
		if (source == null)
			return null;
		try {
			return getStandardDateTimeFormat().parse(source);
		} catch (ParseException e) {
			logger.error("String cast to date,argument: ".concat(source).concat(e.getMessage()));
		}
		return null;
	}

	public static String toStandardDate(Date date) {
		if (date == null)
			return null;
		return getStandardDateFormat().format(date);
	}

	public static String toStandardDateTime(Date date) {
		if (date == null)
			return null;
		return getStandardDateTimeFormat().format(date);
	}

	public static Date convert(String source, String formatString) {
		if(StringUtils.isEmpty(source))
			return null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
		try {
			return dateFormat.parse(source);
		} catch (ParseException e) {
			logger.error("String cast to date,argument: ".concat(source).concat(e.getMessage()));
			return null;
		}
	}

	public static String convert(Date date, String formatString) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
		return simpleDateFormat.format(date);
	}

	/**
	 * 将yyyy-MM-dd日期格式的字符串转为yyMMdd
	 * @param source
	 * @return
	 */
	public static String toShortDate(String source) {
		if (source != null && source.length() == 10) {
			return source.substring(2, 4) + source.substring(5, 7) + source.substring(8, 10);
		}
		return null;
	}

	/**
	 * [根据日期获取对应的字符串：格式HH:mm]
	 * @param date
	 * @return
	 */
	public static String toStandardShortTime(Date date) {
		return convert(date, STANDARD_SHORT_TIME_FORMAT);
	}


	public static long substractInYear(Date d1, Date d2) {
		long substractResult = substract(d1, d2);
		return substractResult / YEAR;
	}

	public static long substractInDay(Date d1, Date d2) {
		long substractResult = substract(d1, d2);
		return substractResult / DAY;
	}

	public static long substractInDay(String s1, String s2) {
		Date d1 = convert(s1, STANDARD_DATE_FORMAT);
		Date d2 = convert(s2, STANDARD_DATE_FORMAT);
		return substractInDay(d1, d2);
	}

	public static long substractInHour(Date d1, Date d2) {
		long substractResult = substract(d1, d2);
		return substractResult / HOUR;
	}

	public static long substractInMinute(Date d1, Date d2) {
		long substractResult = substract(d1, d2);
		return substractResult / MINUTE;
	}

	public static long substractInMinute(String s1, String s2) {
		Date d1 = convert(s1, STANDARD_SHORT_TIME_FORMAT);
		Date d2 = convert(s2, STANDARD_SHORT_TIME_FORMAT);
		return substract(d1, d2) / MINUTE;
	}

	/**
	 * [计算两个时间相差的分钟数]
	 * @param timeregion 格式要求为:9:00-12:00
	 * @return
	 */
	public static long substractInMinute(String timeregion) {
		String[] timeArray = timeregion.split("-");
		if (StringUtils.equals("00:00", timeArray[1]))
			timeArray[1] = "24:00";
		return substractInMinute(timeArray[1], timeArray[0]);
	}

	public static long substractInSecond(Date d1, Date d2) {
		long substractResult = substract(d1, d2);
		return substractResult / SECOND;
	}

	public static long substract(Date d1, Date d2) {
		if (d1 == null || d2 == null) {
			return 0;
		}
		return d1.getTime() - d2.getTime();
	}

	public static String addDays(String source, String dateTimeStringFormat, int days) {
		Date date = DateUtil.convert(source, dateTimeStringFormat);
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_YEAR, days);
			return DateUtil.convert(calendar.getTime(), dateTimeStringFormat);
		}
		return null;
	}

	public static Date addDays(Date date, Integer days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		Date totalDate = cal.getTime();
		return totalDate;
	}

	public static String addMinutes(String source, String dateTimeStringFormat, int minutes) {
		Date date = DateUtil.convert(source, dateTimeStringFormat);
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MINUTE, minutes);
			return DateUtil.convert(calendar.getTime(), dateTimeStringFormat);
		}
		return null;
	}

	/**
	 * [获取日期对应的星期]
	 * @return
	 * @throws Throwable
	 */
	public static String dayForWeek(String pdate) {
		Date date = toStandardDate(pdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return convertToChineseWeek(dayForWeek);
	}

	/**
	 * [转换为中文星期]
	 * @return
	 */
	public static String convertToChineseWeek(int n) {
		String prefix = "星期";
		String suffix = "";
		switch (n) {
			case 1:
				suffix = "一";
				break;
			case 2:
				suffix = "二";
				break;
			case 3:
				suffix = "三";
				break;
			case 4:
				suffix = "四";
				break;
			case 5:
				suffix = "五";
				break;
			case 6:
				suffix = "六";
				break;
			case 7:
				suffix = "日";
				break;
			default:
				break;
		}
		return prefix.concat(suffix);
	}

	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException {
		if (date == null) {
			return null;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	}

	public static Date convertToDate(XMLGregorianCalendar cal) {
		if (cal == null) {
			return null;
		} else {
			GregorianCalendar ca = cal.toGregorianCalendar();
			return ca.getTime();
		}
	}

	/**
	 * 根据预约时间获取预约开始时间
	 * @param bookTime 格式:2015-03-05 10:00-12:00
	 * @return 2015-03-05 10:00:00
	 */
	public static Date getBookBeginTime (String bookTime) {
		if (StringUtils.isEmpty(bookTime))
			return null;
		return getBookBeginTime(bookTime.substring(0, 10), bookTime.substring(11));
	}

	/**
	 * 根据预约时间获取预约开始时间
	 * @param bookDate 预约日期 格式:2015-03-05
	 * @param bookTimePeriod 预约时间段 格式:10:00-12:00
	 * @return 2015-03-05 10:00:00
	 */
	public static Date getBookBeginTime (String bookDate, String bookTimePeriod) {
		if (StringUtils.isEmpty(bookDate) || StringUtils.isEmpty(bookTimePeriod))
			return null;
		String bookBeginTime = bookDate + " " + bookTimePeriod.substring(0, 4) + ":00";
		return toStandardDateTime(bookBeginTime);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);

		return Integer.parseInt(String.valueOf(between_days));
	}
}