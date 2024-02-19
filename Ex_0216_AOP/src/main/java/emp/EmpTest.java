package emp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import context.Context_4_AOP;

public class EmpTest {
	public static void main(String[] args) throws Exception{
		// AnnotationConfigApplicationContext
		// Spring 프레임워크에서 제공하는 AppclicationContext 인터페이스의 구현체중 하나
		// 이 클래스는 Java Config클래스를 사용하여 Spring 어플리케이션 컨텍스트를 설정하는데 사용한다.
		ApplicationContext context = new AnnotationConfigApplicationContext(Context_4_AOP.class);
		
		EmpManager manager = (EmpManager)context.getBean("empManager");
		
		manager.setEmp(new Emp("1","홍길동"));
		manager.setEmp(new Emp("2","이종철"));
		
		List<Emp> emps = manager.getAllEmps();
		
		System.out.println(emps);
		
		
	}
}
