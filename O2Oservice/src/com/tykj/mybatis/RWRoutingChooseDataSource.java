package com.tykj.mybatis;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**  
 * 
 * spring 路由机制动态查询指定读写数据源类
 * @author LQS
 *  
 */ 
public class RWRoutingChooseDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		String dataSource=DynamicDataSourceHolder.getDataSource();
		return dataSource;
	}
}
