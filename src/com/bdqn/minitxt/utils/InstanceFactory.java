package com.bdqn.minitxt.utils;

import java.io.IOException;
import java.util.Properties;

public class InstanceFactory<T> {

	// 1.饿方式
	private static InstanceFactory instance = new InstanceFactory();

	private InstanceFactory() {

	}

	public static InstanceFactory getInstance() {
		return instance;
	}

	private static Properties prop = null;
	static {
		prop = new Properties();
		try {
			prop.load(InstanceFactory.class.getClassLoader()
					.getResourceAsStream("instanceFile.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public T createInstance(Class<T> t) {
		String key = t.getSimpleName();
		String value = prop.getProperty(key);
		try {
			return (T) Class.forName(value).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// // 2.懒方式
	// private static InstanceFactory instance = null;
	//
	// private InstanceFactory() {
	//
	// }
	//
	// private static InstanceFactory getInstance() {
	// if(instance==null){
	// instance=new InstanceFactory();
	// }
	// return instance;
	// }
}
