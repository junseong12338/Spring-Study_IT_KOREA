package com.korea.di.di3;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;



@Component class Car{};
@Component class SportCar extends Car{};
@Component class Truck extends Car{};
@Component class Engine {};



// @객체 자동 등록
// Component Scaning
// 클래스 앞에() @Component 어노테이션을 붙이고 패키지에 컴포넌트
// 어노테이션이 붙어 있는 클래스를 찾아서 객체로 만들어 맵에 저장하는 기법
// 객체 저장소
class AppContext{
	Map map; 
	public AppContext() throws Exception{
		map = new HashMap();
		doComponentScan();
	}
	
	private void doComponentScan() throws Exception{
		
		// 1. 패키지내 클래스 목록 가져온다
		// 2. 반복문으로 클래스를 하나씩 읽어와서 @Component가 붙어있는지 확인
		// 3. @Component가 붙어 있어 있으면 객체를 생성해서 map으로 저장한다.
		
		ClassLoader classLoader = AppContext.class.getClassLoader();
		ClassPath classPath = ClassPath.from(classLoader);
		
		Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.korea.di.di3");
		
		for(ClassPath.ClassInfo classInfo : set) {
			Class clazz = classInfo.load();
			Component component = (Component)clazz.getAnnotation(Component.class);
			if(component != null) {
				String id = StringUtils.uncapitalize(classInfo.getSimpleName());
				map.put(id, clazz.newInstance());
			}
		}
	}
	
	//이름으로 찾기
	Object getBean(String id){
		return map.get(id);
	}

	//타입으로 찾기
	Object getBean(Class clazz) {
		for(Object obj : map.values()) {
			if(clazz.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}
}


public class Main3 {
	

	public static void main(String[] args)throws Exception {
		AppContext ac = new AppContext();
		
		
		Car car = (Car)ac.getBean("car"); //byName으로 객체를 검색
		System.out.println("car= " + car);
		
		Car car2 = (Car)ac.getBean(Car.class); //byType으로 객체를 검색
		System.out.println("car2= " + car2);
		
		Engine engine = (Engine)ac.getBean("engine");
		System.out.println("engine= " + engine);
	}

}
