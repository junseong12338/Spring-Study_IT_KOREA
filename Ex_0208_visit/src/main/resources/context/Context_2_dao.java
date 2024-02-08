package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.VisitDAO;



//  ���������� ���� Ŭ������ ������������ �˷��ִ� ������̼�
@Configuration
public class Context_2_dao {

	@Bean
	public VisitDAO visitDAO(SqlSession sqlSession) {
		return new VisitDAO(sqlSession);
	}

	
}
