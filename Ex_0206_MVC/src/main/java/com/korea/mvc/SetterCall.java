package com.korea.mvc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

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
			Method method = null;
			
			try {
				// map에 필드와 일치하는 키가 있을 때만, sertter호출
				if(value == null) continue;
				
				method = clazz.getDeclaredMethod(getSetterName(name),type);
				System.out.println("method="+method);
				method.invoke(obj, convertTo(value, type)); // obj의 setter를 호출
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Arrays.toString(ivArr));
		
		return obj;
	}

	private static Object convertTo(Object value, Class<?> type) {
		// value의 타입과 type의 타입이 같으면 그대로 반환
		if(value ==null || type ==null || type.isInstance(value)) return value;
		// Stinrg -> int 변환
		if(String.class.isInstance(value) && type == int.class) return Integer.valueOf(""+value);
			
		return value;
	}
	
	// 객체 변수 이름으로 setter의 이름을 만들어서 반환하는 메서드 (name -> setName)
	private static String getSetterName(String name) {
		return "set" +StringUtils.capitalize(name);
	}
}
