package com.wowowo.springmvc.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConveter implements Converter<String, Date> {

	@Override
	public Date convert(String str) {
		
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new Date();
	}

	
	
	
}
