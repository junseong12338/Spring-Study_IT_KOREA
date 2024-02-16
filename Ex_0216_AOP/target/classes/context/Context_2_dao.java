package context;


import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import advice.Advice;
import dao.TestDAO;



// ���������� ���� Ŭ������ ������������ �˷��ִ� ������̼�
@Configuration
@EnableAspectJAutoProxy
// ������̼����� AspectJ ��Ÿ���� �����ϵ��� Ȱ��ȭ �Ѵ�.
// AspectJ �ڹٿ����� ���ߵ� ������ AOP ������ ��ũ�� �θ� ���ȴ�
// �� ������̼��� ����Ͽ� AspectJ ��Ÿ���� AOP�� Ȱ��ȭ �ϸ�, �������� @Aspect ������̼���
// ���� Ŭ������ ã�Ƽ� ���Ͻø� �����ϰ�, �ش� Aspect�� �����Ѵ�.
public class Context_2_dao {
	
	
	@Bean
	public TestDAO testDAO(SqlSession sqlSession) {
		return new TestDAO(sqlSession);
	}
	
	@Bean
	public Advice advice() {
		return new Advice();
	}
	

}
