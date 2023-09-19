package com.iotek.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String formatDate(Date date) {
		DateFormat df = new SimpleDateFormat(PATTERN);
		return df.format(date);
	}
}
