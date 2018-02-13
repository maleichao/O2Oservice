package com.tykj.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**  
    * 自定义DataSource注解
    * RUNTIME  
    * @author LQS
    *  
    */  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  

public @interface DataSource {
	String value(); 
}
