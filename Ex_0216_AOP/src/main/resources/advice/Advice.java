package advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {
	//Pointcut : JoinPoint의 상세한 스펙을 정의한 것. 더욱 구체적으로 Advice가 실행될 지점을 정할 수 있다.

	//* : 반환 타입
	//excution : 메서드 실행을 나타내는 키워드
	//dao.*DAO : dao패키지의 DAO로 끝나는 모든 클래스
	//.* : 모든 메서드
	//(..) : 메서드의 전달되는인자 ..은 어떤 개수의 인자든지 가능하다. 
	
	@Pointcut("execution(* dao.*DAO.*(..))")
	public void myPoint() {}

}
