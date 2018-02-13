package com.tykj.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * @param 返回 yyyy-MM-dd HH-mm-ss
	 * */
	public static Date getTimestamp(){
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH-mm-ss"); 
		String dateString = formatter.format(new Date()); 
		try {
			Date timeDate = formatter.parse(dateString);
			Timestamp timestamp = new Timestamp(timeDate.getTime());
		return timestamp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**将字符串转换时间*/
	public static Date getDateByString(String dateString,String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format); 
		try {
			Date date=formatter.parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * 将字符串转换时间
	 * 格式 yyyy-MM-dd HH-mm-ss
	 * */
	public static Date getDateByString(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
		try {
			Date date=formatter.parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
