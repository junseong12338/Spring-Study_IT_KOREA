package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	
	@Before("myPoint()")
	public void before(JoinPoint jp) {
		//getSignature() : ���� JoinPoint���� ����Ǵ� �޼����� ����(Signature)������ ��ȯ�Ѵ�.
				//���� �������� �޼����, ���� Ÿ��, �Ķ���� Ÿ�Ե��� ���Եȴ�.
				//.getName() : �޼����
				//.getReturnType() : ����Ÿ��
				//.getParameterTypes() : �Ķ���� Ÿ�Ե�
		System.out.println("----before:"+jp.getSignature());
		
	}
	@After("myPoint()") //- After Advice: Exception �߻� ���ο� ������� ��� ��ü�� Method ���� �� ���� ����� ����
	public void after(JoinPoint jp) {
		//toLongString ȣ���ϴ� �޼����� ��� ����(����,�̸�,�ŰԺ���), ��θ� �����Ͽ� ��ȯ
		System.out.println("---after:"+jp.toLongString());
	}

}
