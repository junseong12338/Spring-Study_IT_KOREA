package com.korea.di.di1;

import java.io.FileReader;
import java.util.Properties;

class Car{};
class SportCar extends Car{};
class Truck extends Car{};
class Engine {};

public class Main1 {
	public static void main(String[] args) throws Exception{
		Car car = (Car)getObject("car");
		System.out.println("car="+ car);
		
		Engine engine =  (Engine)getObject("engine");
		System.out.println("engine="+ engine);
	}

	private static Object getObject(String key) throws Exception{
		
		
		Properties p = new Properties();
		
		p.load(new FileReader("config.txt"));
		Class clazz = Class.forName(p.getProperty(key));
		
		return clazz.newInstance();
	}
	
	 


}
