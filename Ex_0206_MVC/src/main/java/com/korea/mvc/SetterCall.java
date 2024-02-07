package com.korea.mvc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

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
		}
		
		return null;
	}
}
