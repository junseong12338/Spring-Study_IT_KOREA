package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import emp.EmpLoggingAspect;
import emp.EmpManager;

//  ���������� ���� Ŭ������ ������������ �˷��ִ� ������̼�
@Configuration
@EnableAspectJAutoProxy
public class Context_4_AOP {
	
	@Bean
	public EmpManager empManager() {
		return new EmpManager();
	}
	
	@Bean
	public EmpLoggingAspect longAspect() {
		return new EmpLoggingAspect();
	}
	
	
}
