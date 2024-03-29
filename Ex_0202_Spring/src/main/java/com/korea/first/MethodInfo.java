package com.korea.first;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	
	public static void main(String[] args) throws Exception{
		// 스프링이 매개변수 얻어오는 두가지 방법
		// 1.  reflection API
		// 먼저 reflection API를 통해서 매개변수의 이름을 얻어오려고 시도한다.
		// 2 . Class File
		// 1. 방법 실패하면 클래스파일을 직접 읽어서 매개변수의 이름을 가져온다.
		
		// Class클래스 : 클래스 정보를 얻어오기 위한 클래스
		// forName() : 클래스의 파일명은 인자로 넣어주면 해당 클래스 정보 반환
		Class clazz = Class.forName("com.korea.first.YoilTeller");
		
		// 새로운 객체 생성
		Object obj  = clazz.newInstance();
		
		// 모든 메서드 정보 가져와 배열에 저장
		
		// 상속한 메서드를 제외 접근지정자 상관없이 모든 메서드 가져온다.
		Method[] methodArr = clazz.getDeclaredMethods();
		for(Method m : methodArr) {
			String name = m.getName();//메서드의 이름
			Parameter[] paramArr = m.getParameters(); //매개변수
			Class returnType = m.getReturnType();//반환 타입
			
			//", " : 구분자
			//"(" : 접두사
			//")" : 접미사
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			// 파라미터 이름을 보려고하는 반복문
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} 
}
