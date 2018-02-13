package com;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;








import java.util.Map;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class TestMain {
	public static void main(String[] args) throws Exception{
		List list=new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("e");
		list.add("d");
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
			System.out.println(o1+","+o2);
			System.out.println(String.valueOf(o1).compareTo(String.valueOf(o2)));
			 return String.valueOf(o1).compareTo(String.valueOf(o2));
		}});
		System.out.println(list);
	}

}
