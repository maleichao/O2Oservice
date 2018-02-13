package com.tykj.mybatis;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;  
/**  
 * 
 * 选择读写数据源处理切面类
 * @author LQS
 *  
 */ 
public class DataSourceAspect {
	public void pointCut() {};

	public void before(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();
		Class<?>[] classz = target.getClass().getInterfaces();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			if (m != null&&m.isAnnotationPresent(DataSource.class)) {
				DataSource data = m.getAnnotation(DataSource.class);
				DynamicDataSourceHolder.putDataSource(data.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
