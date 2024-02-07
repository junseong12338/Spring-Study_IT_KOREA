package com.korea.mvc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SetterCall {
	public static void main(String[] args) throws Exception{
		
		// 요청한 값이 HashMap에 담겨 있다고 했을 때
		Map<String, String> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("tel", "010-1234-5678");
		map.put("age", "10");
		
		Class<?> type = Class.forName("dto.PersonDTO");
		
		Object obj = dataBind(map,type);
		System.out.println("obj="+obj);
	}

	private static Object dataBind(Map<String, String> map, Class<?> clazz) throws Exception {
		// 1. PersonDTO 인스턴스 생성
		Object obj = clazz.getDeclaredConstructor().newInstance(new Object[0]);
		
		// 2. PersonDTO의 sertter를 호출해서, map의 값으로 객체를 초기화
		// 2-1. PersonDTO의 모든 필드를 돌면서 map에 있는지 찾는다.
		// 2-2. 찾으면, 찾은 값을 setter로 객체에 저장한다. 
		
		Field[] ivArr =clazz.getDeclaredFields();
		 
		for(int i = 0 ; i< ivArr.length; i++) {
			String name = ivArr[i].getName();
			Class<?> type = ivArr[i].getType();
			
			Object value = map.get(name);
		}
		
		return null;
	}
}
