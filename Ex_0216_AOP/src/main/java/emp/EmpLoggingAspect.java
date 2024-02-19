package emp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpLoggingAspect {
	
	@Before("execution(* emp.EmpManager.get*(..))")
	public void before(JoinPoint jp) {
		System.out.println(">>>>>>> Before Advice[��] : " + jp.getSignature().getName());
	}
	
	// @Around ������̼��� ����ϸ� ����Ʈ�� �޼��尡 ����Ǳ� �� , ���� ���� advice�� ����ȴ�.
	// advice method �� ù��° �Ķ���ʹ� ProceedingJoinPoint�� �Ǿ�� �Ѵ�.
	// proceed() �޼��带 ���� Ÿ�� Ŭ������ ���� �޼��带 ȣ��
	@Around("execution(* emp.EmpManager.get*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>>>>>> Around Advice[��] : " + pjp.getSignature().getName());
		Object o = pjp.proceed();
		System.out.println(">>>>>>> Around Advice[��] : " + pjp.getSignature().getName());
		return o;
	
	}
	
	// ����Ʈ�� �޼��尡 ���� ���� ���� advice�� ���� �ȴ�.
	@AfterReturning(pointcut =  "execution(* emp.EmpManager.get*(..))", returning = "retVal")
	public void afterReturning(JoinPoint jp, Object retVal) {
		System.out.println(">>>>>>> AfterReturning Advice : " + jp.getSignature().getName());
		System.out.println(">>>>>>> AfterReturning Advice return value is  : " + retVal);

	}
	
  	//@After ������̼��� ����Ѵ�. ����Ʈ�� �޼ҵ尡 ����� ��(��������, ���ܹ߻� ���ο� �������) advice�� ����ȴ�.
	@After("execution(* emp.EmpManager.get*(..))")
	public void after(JoinPoint jp) {
		System.out.println(">>>>>>> After Advice : " + jp.getSignature().getName());

	}
	
	//@AfterThrowing ������̼��� ����ϸ� ����Ʈ�� �޼ҵ忡�� ���ܰ� �߻��� �� ��� ����ȴ�.
	@AfterThrowing(pointcut =  "execution(* emp.EmpManager.get*(..))", throwing = "ex")
	public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		System.out.println(">>>>>>> @AfterThrowing Advice : " + ex);

	}
	
	// ���� ���� : @Around -> @Before -> @After -> @AfterReturning -> @AfterTheowing
	// ��ȯ�� ���� ��� ȣ��
	
	
	
}
