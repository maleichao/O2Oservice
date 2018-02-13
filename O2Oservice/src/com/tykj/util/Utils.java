package com.tykj.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.tykj.member.model.Member;

/**
 *工具方法
 * 
 */
public class Utils {

	/**
	 * 
	 * @return 获取23位时间+四位随机数的编码
	 */
	public static String getRandomCode() {
		String randomCode = null;
		SimpleDateFormat sDateFormat;
		Random r = new Random();
		int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmsssss"); // 时间格式化的格式
		randomCode = sDateFormat.format(new Date()) + rannum;
		return randomCode;
	}
	/**
	 * 返回随机8位字符串。
	 * 
	 * @return 返回随机8位字符串
	 */
	public static String get8RandomCodeForUUID(){
		return UUID.randomUUID().toString().toUpperCase().substring(0,8);
	}
	/**
	 * 返回随机传入的bitNum位字符串。
	 * @param bitNum
	 *            传入返回的整形位数
	 * @return 返回随机bitNum位字符串
	 */
	public static String getRandomCodeForUUID(int bitNum){
		return UUID.randomUUID().toString().toUpperCase().substring(0,bitNum);
	}
	
	/**
	 * 判断字符串是否为空 ， 空：false ; 非空：true。
	 * @param ch
	 *            传入字符串
	 * @return 真假
	 */
	public static boolean stringIsNotEmpty(String ch){
		if(ch!=null && !"".equals(ch)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断Object对象不为空 ， 空：false ; 非空：true。
	 * @param obj
	 *            传入对象
	 * @return 真假
	 */
	public static boolean objectIsNotEmpty(Object obj){
		if(obj!=null && !"".equals(obj)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断Object对象为空 ， 空：true; 非空：false。
	 * @param obj
	 *            传入对象
	 * @return 真假
	 */
	public static boolean objectIsEmpty(Object obj){
		if(obj!=null && !"".equals(obj)){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 判断集合是否为空， 空：false ; 非空：true。
	 * @param coll
	 *            传入集合
	 * @return 真假
	 */
	public static boolean collectionIsNotEmpty(Collection<?> coll){
		if(coll!=null && coll.size()>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @return 获取MD5编码字符串值，算法不可逆。
	 */
	public final static String EncodeMd5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] md5Password = md5.digest(s.getBytes());
			int j = md5Password.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md5Password[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * @param urls  带有“@”组合的“，”分割的URL字符串
	 * @return 返回一个不带@后面组合信息的带有“，”的URl组合字符串
	 */
	public static String getUrlsValueByDeal(String urls){
		if(urls!=null&&!"".equals(urls)){
			StringBuilder sb=new StringBuilder(); 
			String [] fileUrls= urls.split(",");
			if(fileUrls.length==1){
				sb.append(fileUrls[0].substring(0,fileUrls[0].indexOf("@")));
			}else{
				
				for(int i=0;i<fileUrls.length;i++){
					if(i==fileUrls.length-1){
						sb.append(fileUrls[i].substring(0,fileUrls[i].indexOf("@")));
					}else{
						sb.append(fileUrls[i].substring(0,fileUrls[i].indexOf("@"))).append(",");
					}
				}
			}
			return sb.toString();
		}else{
			return "";
		}
		
	}
	/**
	 * 判断exsitsUrlsStr中是否包含地址deleteURL。
	 * @param exsitsUrlsStr
	 *            传入包含url
	 * @param deleteURL
	 *            传入查找url
	 * @return 真假
	 */
	public static boolean isFindUrl(String exsitsUrlsStr,String deleteURL){
		boolean isFind = false;
		String[] exsitsUrls = exsitsUrlsStr.split(",");
		for (int i = 0; i < exsitsUrls.length; i++) {
			if (exsitsUrls[i].equals(deleteURL)) {isFind = true;break;}
		}
		return isFind;
	}
	
	/**
	 * 将条件中汉字带英文的'替换成" 避免和合sql的的'产生冲突，适用于Oracle
	 * @param condition
	 * @return 
	 */
	public static String replaceSelectCharForSQL(String condition){
		return condition.replaceAll("'", "''");
	}
	
	/**
	 * 转换字符串为int 转换失败返回defaultVal
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	public static int parseInt (String str , int defaultVal){
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}
	/**
	 * 把集合转换成字符串，以拼接符的形式分开
	 * @param list  集合
	 * @param str 分隔符
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String listToString(List list,String str){
		if(list!=null){
			Object [] arrayStr = list.toArray();
			return StringUtils.join(arrayStr, ",");
		}else{
			return "";
		}
	}
	
	/**
	 * 去除首尾逗号(,)用于sql语句in查询时使用
	 * @param list  集合
	 * @param str 分隔符
	 * @return
	 */
	public static String removerComma(String str){
		if(stringIsNotEmpty(str)){
			return str.replaceAll("(?:^,+)|(?:,+$)|(,),+", "$1");
		}else{
			return "";
		}
	}
	public static Date getDateTime(String formatters){
		SimpleDateFormat formatter = new SimpleDateFormat(formatters); 
		String dateString = formatter.format(new Date()); 
		java.util.Date timeDate;
		java.sql.Timestamp timestamp;
		try {
			timeDate = formatter.parse(dateString);
			timestamp = new java.sql.Timestamp(timeDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	return timestamp;
	}
	/**
	 * 将map转为javaBean
	 * 注意类型格式
	 * */
    public static void transMap2Bean2(Map<String, Object> map, Object obj) {  
        if (map == null || obj == null) {  
            return;  
        }  
        try {  
            BeanUtils.populate(obj, map);  
        } catch (Exception e) {  
            System.out.println("transMap2Bean2 Error " + e);
        }  
    }  
	/**
	 * 测试使用
	 */
	public static void main(String[] args) throws ParseException {
		//System.out.println(EncodeMd5("admin"));
		Member member=new Member();
		Map map=new HashMap();
		map.put("memberId", "1");
		///map.put("memberName", 1223);
		map.put("test", 1);
		transMap2Bean2(map, member);
		//System.out.println(member.getMemberName());
		System.out.println(member.getMemberId());
	}
	
}
