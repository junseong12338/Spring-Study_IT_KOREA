package emp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import context.Context_4_AOP;

public class EmpTest {
	public static void main(String[] args) throws Exception{
		// AnnotationConfigApplicationContext
		// Spring �����ӿ�ũ���� �����ϴ� AppclicationContext �������̽��� ����ü�� �ϳ�
		// �� Ŭ������ Java ConfigŬ������ ����Ͽ� Spring ���ø����̼� ���ؽ�Ʈ�� �����ϴµ� ����Ѵ�.
		ApplicationContext context = new AnnotationConfigApplicationContext(Context_4_AOP.class);
		
		EmpManager manager = (EmpManager)context.getBean("empManager");
		
		manager.setEmp(new Emp("1","ȫ�浿"));
		manager.setEmp(new Emp("2","����ö"));
		
		List<Emp> emps = manager.getAllEmps();
		
		System.out.println(emps);
		
		
	}
}
