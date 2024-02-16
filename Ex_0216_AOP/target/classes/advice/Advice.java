package advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {
	//Pointcut : JoinPoint�� ���� ������ ������ ��. ���� ��ü������ Advice�� ����� ������ ���� �� �ִ�.

	//* : ��ȯ Ÿ��
	//excution : �޼��� ������ ��Ÿ���� Ű����
	//dao.*DAO : dao��Ű���� DAO�� ������ ��� Ŭ����
	//.* : ��� �޼���
	//(..) : �޼����� ���޵Ǵ����� ..�� � ������ ���ڵ��� �����ϴ�. 
	
	@Pointcut("execution(* dao.*DAO.*(..))")
	public void myPoint() {}

}
