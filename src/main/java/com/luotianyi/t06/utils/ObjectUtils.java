package com.luotianyi.t06.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtils {
	private ObjectUtils() {}
	public static Map<String, Object> objectToMap(Object object) {
		Map<String, Object> hashMap = new HashMap<>();
		Field[] declaredFields = object.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.getName().equals("serialVersionUID"))
				continue;
			field.setAccessible(true);
			try {
				hashMap.put(field.getName(), field.get(object));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return hashMap;
	}

	public static <T> T hashMapToObj(Map<String, Object> data, Class<T> tClass)
			throws InstantiationException, IllegalAccessException {

		Field[] declaredFields = tClass.getDeclaredFields();
		T t1 = tClass.newInstance();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			field.set(t1, data.get(field.getName()));
		}
		return t1;
	}
	
//	private Object packing(Field field) {
//		if(field.getType().getName().equals("int"))
//			return new Integer(field);
//	}
}
