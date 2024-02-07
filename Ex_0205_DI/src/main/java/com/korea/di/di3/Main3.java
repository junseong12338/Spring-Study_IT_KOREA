package com.korea.di.di3;

import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;



@Component class Car{};
@Component class SportCar extends Car{};
@Component class Truck extends Car{};
@Component class Engine {};



// @��ü �ڵ� ���
// Component Scaning
// Ŭ���� �տ�() @Component ������̼��� ���̰� ��Ű���� ������Ʈ
// ������̼��� �پ� �ִ� Ŭ������ ã�Ƽ� ��ü�� ����� �ʿ� �����ϴ� ���
// ��ü �����
class AppContext{
	Map map; 
	public AppContext() throws Exception{
		map = new HashMap();
		doComponentScan();
	}
	
	private void doComponentScan() throws Exception{
		
		// 1. ��Ű���� Ŭ���� ��� �����´�
		// 2. �ݺ������� Ŭ������ �ϳ��� �о�ͼ� @Component�� �پ��ִ��� Ȯ��
		// 3. @Component�� �پ� �־� ������ ��ü�� �����ؼ� map���� �����Ѵ�.
		
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
	
	//�̸����� ã��
	Object getBean(String id){
		return map.get(id);
	}

	//Ÿ������ ã��
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
		
		
		Car car = (Car)ac.getBean("car"); //byName���� ��ü�� �˻�
		System.out.println("car= " + car);
		
		Car car2 = (Car)ac.getBean(Car.class); //byType���� ��ü�� �˻�
		System.out.println("car2= " + car2);
		
		Engine engine = (Engine)ac.getBean("engine");
		System.out.println("engine= " + engine);
	}

}