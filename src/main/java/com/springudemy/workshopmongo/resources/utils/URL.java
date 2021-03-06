package com.springudemy.workshopmongo.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class URL {

	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String textDate, Date defaultValue) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
	
	public static List<Integer> decodeIntList(String s){
		return Arrays.asList(s.split(",")).stream()
					.map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}
	
}