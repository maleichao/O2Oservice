package com.tykj.mybatis;

/**  
 * 
 * 数据源选择处理类
 * @author LQS
 *  
 */  
public class DynamicDataSourceHolder {
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();

	public static void putDataSource(String datasource) {
		holder.set(datasource);
	}

	public static String getDataSource() {
		return holder.get();
	}
}
