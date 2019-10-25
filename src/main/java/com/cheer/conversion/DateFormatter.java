package com.cheer.conversion;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.cheer.util.DateUtil;

public class DateFormatter implements Formatter<Date>{
	
	@Override
	public String print(Date object, Locale locale) {
		return DateUtil.dateFormat(object,DateUtil.DATETIME_PATTERN);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if(text.length()==10) {
			return DateUtil.dateParse(text, DateUtil.DATE_PATTERN);
		}else if(text.length()==20) {
			return DateUtil.dateParse(text, DateUtil.DATETIME_PATTERN);
		}else if(text.length()==17) {
			return DateUtil.dateParse(text, DateUtil.DATEMINUTE_PATTERN);
		}
		return null;
	}

}
