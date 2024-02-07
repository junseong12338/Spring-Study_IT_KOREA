package com.korea.di.di4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

import lombok.ToString;


// �ڵ����� ������ ���� �ʿ�� �Ѵ�.
@Component 
@ToString
class Car{
	@Autowired
	Engine engine;
	@Autowired
	Door door;	
};

@Component class SportCar extends Car{};
@Component class Truck extends Car{};
@Component class Engine {};
@Component class Door {};

class AppContext{
	Map map; 
	public AppContext() throws Exception{
		map = new HashMap();
		doComponentScan();
		doAutowired();
	}
	
	private void doComponentScan() throws Exception{
	
		ClassLoader classLoader = AppContext.class.getClassLoader();
		ClassPath classPath = ClassPath.from(classLoader);
		
		Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.korea.di.di4");
		
		for(ClassPath.ClassInfo classInfo : set) {
			Class clazz = classInfo.load();
			Component component = (Component)clazz.getAnnotation(Component.class);
			if(component != null) {
				String id = StringUtils.uncapitalize(classInfo.getSimpleName());
				map.put(id, clazz.newInstance());
			}
		}
	}
	
	
	private void doAutowired() throws Exception{
		for(Object bean : map.values()) {
			for(Field fld : bean.getClass().getDeclaredFields()) {
				if(fld.getAnnotation(Autowired.class)!=null) {
					fld.set(bean, getBean(fld.getType()));
				}
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


public class Main4 {
	

	public static void main(String[] args)throws Exception {
		AppContext ac = new AppContext();
		
		
		Car car = (Car)ac.getBean("car"); //byName���� ��ü�� �˻�
		
		Engine engine = (Engine)ac.getBean("engine");
		
		
		Door door = (Door)ac.getBean(Door.class);
		
		
//		car.engine=engine;
//		car.door = door;
		
		System.out.println("car= " + car);
		System.out.println("engine= " + engine);
		System.out.println("door= " + door);
	}

}