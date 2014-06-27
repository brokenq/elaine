package com.brokenq.elaine.core.utils;

import static com.brokenq.elaine.core.utils.StringUtils.getByteLength;
import static com.brokenq.elaine.core.utils.StringUtils.isNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * @since 2014年6月27日 下午4:38:20
 * @author brokenq
 */
public class DateUtils {

	/**
	 * 是否日期
	 * @param dateString 日期字符串
	 * @param fmtString 格式化字符串
	 * @return 【true：日期；false：非日期】
	 * @since 2014年6月20日 下午2:08:42
	 * @author brokenq
	 */
	public static boolean isDate(String dateString, String fmtString){
		return null != str2Date(dateString, fmtString);
	}
	
	/**
	 * 是否日期【默认格式：yyyyMMddHHmmss】
	 * @param dateString 日期字符串
	 * @return 【true：日期；false：非日期】
	 * @since 2014年6月20日 下午2:26:26
	 * @author brokenq
	 */
	public static boolean isDate(String dateString){
		return null != str2Date(dateString);
	}
	
	/**
	 * 字符串转日期
	 * @param dateString 日期字符串
	 * @param fmtString 格式化字符串
	 * @return 【成功：返回转换后的日期；失败：返回null】
	 * @since 2014年6月20日 下午2:20:03
	 * @author brokenq
	 */
	public static Date str2Date(String dateString, String fmtString){
		if(isNull(dateString) || isNull(fmtString)) return null;
		if(getByteLength(dateString) != getByteLength(fmtString)) return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(fmtString);
		try {
			dateFormat.setLenient(false);
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 字符串转日期【默认格式：yyyyMMddHHmmss】
	 * @param dateString 日期字符串
	 * @return 【成功：返回转换后的日期；失败：返回null】
	 * @since 2014年6月20日 下午2:22:50
	 * @author brokenq
	 */
	public static Date str2Date(String dateString){
		return str2Date(dateString, "yyyyMMddHHmmss");
	}
	
}
