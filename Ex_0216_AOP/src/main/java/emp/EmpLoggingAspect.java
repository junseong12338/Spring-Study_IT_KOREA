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
		System.out.println(">>>>>>> Before Advice[전] : " + jp.getSignature().getName());
	}
	
	// @Around 어노테이션을 사용하면 포인트컷 메서드가 실행되기 전 , 리턴 된후 advice가 적용된다.
	// advice method 의 첫번째 파라미터는 ProceedingJoinPoint가 되어야 한다.
	// proceed() 메서드를 통해 타켓 클래스의 원래 메서드를 호출
	@Around("execution(* emp.EmpManager.get*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>>>>>> Around Advice[전] : " + pjp.getSignature().getName());
		Object o = pjp.proceed();
		System.out.println(">>>>>>> Around Advice[후] : " + pjp.getSignature().getName());
		return o;
	
	}
	
	// 포인트컷 메서드가 정상 종료 된후 advice가 적용 된다.
	@AfterReturning(pointcut =  "execution(* emp.EmpManager.get*(..))", returning = "retVal")
	public void afterReturning(JoinPoint jp, Object retVal) {
		System.out.println(">>>>>>> AfterReturning Advice : " + jp.getSignature().getName());
		System.out.println(">>>>>>> AfterReturning Advice return value is  : " + retVal);

	}
	
  	//@After 어노테이션을 사용한다. 포인트컷 메소드가 실행된 후(정상종료, 예외발생 여부와 관계없이) advice가 적용된다.
	@After("execution(* emp.EmpManager.get*(..))")
	public void after(JoinPoint jp) {
		System.out.println(">>>>>>> After Advice : " + jp.getSignature().getName());

	}
	
	//@AfterThrowing 어노테이션을 사용하며 포인트컷 메소드에서 예외가 발생할 때 충고가 적용된다.
	@AfterThrowing(pointcut =  "execution(* emp.EmpManager.get*(..))", throwing = "ex")
	public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		System.out.println(">>>>>>> @AfterThrowing Advice : " + ex);

	}
	
	// 실행 순서 : @Around -> @Before -> @After -> @AfterReturning -> @AfterTheowing
	// 반환은 역순 재귀 호출
	
	
	
}
