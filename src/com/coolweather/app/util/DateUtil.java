package com.coolweather.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.text.TextUtils;

public class DateUtil {

	public static final SimpleDateFormat sf2 = new SimpleDateFormat("h:mm:ss a", Locale.US);
	// 6/19/2016 3:47:13 PM
	public static final SimpleDateFormat sf3 = new SimpleDateFormat("M/dd/yyyy h:mm:ss a",
			Locale.US);
	public static final SimpleDateFormat sf4 = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss",
			Locale.CHINA);

	/**
	 * 格式化时间：6/19/2016 9:00:24 AM
	 * 
	 * @param surDate
	 *            源时间
	 * @return yyyy-MM-dd 下午 h:ss:mm、日期、时间
	 */
	public static String[] formatDateTime(String surDate) {
		String[] array = new String[3];
		String dateTime = null;
		if (!TextUtils.isEmpty(surDate)) {

			try {
				Date parse = sf3.parse(surDate);
				dateTime = sf4.format(parse);
				String[] split = dateTime.split(" ");
				array[0] = dateTime;
				array[1] = split[0];
				array[2] = split[1];
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return array;
	}

	/**
	 * 格式化时间： 9:00:24 AM
	 * 
	 * @param surDate
	 *            源时间
	 * @return 下午 h:ss:mm
	 */
	public static String formatTime(String surDate) {
		String time = null;
		if (!TextUtils.isEmpty(surDate)) {
			Date parse;
			try {
				parse = sf2.parse(surDate);
				time = sf4.format(parse);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return time;
	}
}
