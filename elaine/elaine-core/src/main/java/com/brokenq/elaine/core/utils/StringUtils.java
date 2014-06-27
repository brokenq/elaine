package com.brokenq.elaine.core.utils;

/**
 * 字符串工具类
 * @since 2014年6月18日 上午11:25:07
 * @author brokenq
 */
public class StringUtils {
	
	/**
	 * 判断字符串是否为空
	 * @param str 原始字符串
	 * @param isTrim 是否需要去掉前后空格【true：去掉前后空格；false：保留原始字符串】
	 * @return
	 * @since 2014年6月19日 上午11:21:13
	 * @author brokenq
	 */
	public static boolean isNull(String str, boolean isTrim){
		if(null == str) return true;
		if(isTrim) return "".equals(str.trim());
		return "".equals(str);
	}
	
	/**
	 * 判断字符串是否为空【默认去掉前后空格】
	 * @param str 原始字符串
	 * @return
	 * @since 2014年6月19日 上午11:27:07
	 * @author brokenq
	 */
	public static boolean isNull(String str){
		return isNull(str, true);
	}
	
    /**
     * 获取字节长度
     * @param str 待计算的字符串
     * @param isTrim 是否需要去掉前后空格【true：去掉前后空格；false：保留原始字符串】
     * @param dbType 数据库类型【ORACLE、MYSQL、SQLSERVER】
     * <dl>
	 * 	<dd>ORACLE：一个中文字符占3字节</dd>
	 * 	<dd>MYSQL：一个中文字符占3字节</dd>
	 * 	<dd>SQLSERVER：一个中文字符占2字节</dd>
	 * 	<dd>其他：一个中文字符占3字节</dd>
	 * </dl>
     * @return
     * @since 2014年6月18日 下午2:51:30
     * @author brokenq
     */
    public static int getByteLength(String str, boolean isTrim, String dbType){
    	if(isNull(str, isTrim)) return 0;
    	if (isTrim) {
			str = str.trim();
		}
    	if ("ORACLE".equals(dbType) || "MYSQL".equals(dbType)) {
    		return str.replaceAll("[^\\x00-\\xff]", "***").length();
		}
    	if("SQLSERVER".equals(dbType)){
    		return str.replaceAll("[^\\x00-\\xff]", "**").length();
    	}
    	return str.replaceAll("[^\\x00-\\xff]", "***").length();
	}
    
    /**
     * 获取字节长度【Oracle数据库适用，一个中文字符占3个字节】【默认去掉前后空格】
     * @param str 待计算的字符串
     * @return
     * @since 2014年6月18日 下午3:01:47
     * @author brokenq
     */
    public static int getByteLength(String str){
    	return getByteLength(str, true, "ORACLE");
    }
    
    /**
     * 获取字节长度【Oracle数据库适用，一个中文字符占3个字节】
     * @param str 待计算的字符串
     * @param isTrim 是否需要去掉前后空格【true：去掉前后空格；false：保留原始字符串】
     * @return
     * @since 2014年6月19日 上午11:11:13
     * @author brokenq
     */
    public static int getByteLength(String str, boolean isTrim){
    	return getByteLength(str, isTrim, "ORACLE");
    }
    
    public static void main(String[] args) {
    	System.out.println(getByteLength(null, true));
    	System.out.println(getByteLength("   ", true));
    	System.out.println(getByteLength("  s ", true));
    	System.out.println(getByteLength(null, false));
    	System.out.println(getByteLength("   ", false));
		System.out.println(getByteLength("  s ", false));
	}
}
