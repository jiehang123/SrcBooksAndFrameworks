package com.jiehang.ioc;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameworkContainer {

	private static Map<String, Component> componmentMap = new HashMap<>();
	static {
		componmentMap.put("controller", new Component("com.jiehang.ioc.SimpleController", Arrays.asList("fundService")));
		componmentMap.put("fundService", new Component("com.jiehang.ioc.FundServiceImpl", Arrays.asList("fundDao")));
		componmentMap.put("fundDao", new Component("com.jiehang.ioc.FundDaoImpl", null));
		componmentMap.put("processor", new Component("com.jiehang.ioc.SimpleProcessor", Arrays.asList("guidService")));
		componmentMap.put("guidService", new Component("com.jiehang.ioc.GuidServiceImpl", Arrays.asList("guidDao", "tradeDao")));
		componmentMap.put("guidDao", new Component("com.jiehang.ioc.GuidDaoImpl", null));
		componmentMap.put("tradeDao", new Component("com.jiehang.ioc.TradeDaoImpl", null));
	}

	private static Map<String, Object> instanceMap = new HashMap<>();
	
	/*
	 * create all Objects
	 */
	public static void init() {
		for (String id : componmentMap.keySet()) {
			createBean(id);
		}
	}
	
	public static Object getComponment(String ComponentName) {
		return instanceMap.get(ComponentName);
	}
	
	/*
	 * get a instance and put it into instanceMap
	 */
	private static Object createBean(String componentId) {
		Object object = instanceMap.get(componentId);
		if (object == null) {
			try {
				Class<?> clazz = Class.forName(componmentMap.get(componentId).getClazz());
				object = clazz.newInstance();
				instanceMap.put(componentId, object);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		List<String> refList = componmentMap.get(componentId).getRefList();
		if (null != refList) {
			injectBean(object, refList);
		}
		return object;
	}

	/*
	 * Dependency Injection
	 */
	private static void injectBean(Object object, List<String> refList) {
		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (refList.contains(field.getName())) {
					field.setAccessible(true);
					Object value = createBean(field.getName());
					field.set(object, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
