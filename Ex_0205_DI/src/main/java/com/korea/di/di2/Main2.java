package com.korea.di.di2;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{};
class SportCar extends Car{};
class Truck extends Car{};
class Engine {};



//ApplicationCeontext
//객체 저장소라고 한다.
//클래스 안에 Map으로 객체를 저장한다.

class AppContext{
	Map map; // 객체 저장소
	public AppContext() {
		try {
			
			Properties p = new Properties();
			p.load(new FileReader("config.txt"));
			
			map = new HashMap(p);
			
			for(Object key : map.keySet()) {
				Class clazz = Class.forName((String)map.get(key));
				map.put(key, clazz.newInstance());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	Object getBean(String key) {

		return map.get(key);
	}
}

public class Main2 {


	public static void main(String[] args) {
		AppContext ac = new AppContext();
		Car car =  (Car)ac.getBean("car");
		Engine engine =  (Engine)ac.getBean("engine");
		
		System.out.println("car : " + car);
		System.out.println("engine : " + engine);
	}
	
	 


}
