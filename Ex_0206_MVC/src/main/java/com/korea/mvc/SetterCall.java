package com.korea.mvc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class SetterCall {
	public static void main(String[] args) throws Exception{
		
		// ��û�� ���� HashMap�� ��� �ִٰ� ���� ��
		Map<String, String> map = new HashMap<>();
		map.put("name", "ȫ�浿");
		map.put("tel", "010-1234-5678");
		map.put("age", "10");
		
		Class<?> type = Class.forName("dto.PersonDTO");
		
		Object obj = dataBind(map,type);
		System.out.println("obj="+obj);
	}

	private static Object dataBind(Map<String, String> map, Class<?> clazz) throws Exception {
		// 1. PersonDTO �ν��Ͻ� ����
		Object obj = clazz.getDeclaredConstructor().newInstance(new Object[0]);
		
		// 2. PersonDTO�� sertter�� ȣ���ؼ�, map�� ������ ��ü�� �ʱ�ȭ
		// 2-1. PersonDTO�� ��� �ʵ带 ���鼭 map�� �ִ��� ã�´�.
		// 2-2. ã����, ã�� ���� setter�� ��ü�� �����Ѵ�. 
		
		Field[] ivArr =clazz.getDeclaredFields();
		 
		for(int i = 0 ; i< ivArr.length; i++) {
			String name = ivArr[i].getName();
			Class<?> type = ivArr[i].getType();
			
			Object value = map.get(name);
			Method method = null;
			
			try {
				// map�� �ʵ�� ��ġ�ϴ� Ű�� ���� ����, sertterȣ��
				if(value == null) continue;
				
				method = clazz.getDeclaredMethod(getSetterName(name),type);
				System.out.println("method="+method);
				method.invoke(obj, convertTo(value, type)); // obj�� setter�� ȣ��
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Arrays.toString(ivArr));
		
		return obj;
	}

	private static Object convertTo(Object value, Class<?> type) {
		// value�� Ÿ�԰� type�� Ÿ���� ������ �״�� ��ȯ
		if(value ==null || type ==null || type.isInstance(value)) return value;
		// Stinrg -> int ��ȯ
		if(String.class.isInstance(value) && type == int.class) return Integer.valueOf(""+value);
			
		return value;
	}
	
	// ��ü ���� �̸����� setter�� �̸��� ���� ��ȯ�ϴ� �޼��� (name -> setName)
	private static String getSetterName(String name) {
		return "set" +StringUtils.capitalize(name);
	}
}
