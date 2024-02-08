package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.DeptDAO;
import dao.SawonDAO;

//  스프링에게 현재 클래스가 설정파일임을 알려주는 어노테이션
@Configuration
public class Context_2_dao {

	@Bean
	public DeptDAO dept_dao(SqlSession sqlSession) {
		return new DeptDAO(sqlSession);
	}
	
	@Bean
	public SawonDAO sawon_dao(SqlSession sqlSession) {
		return new SawonDAO(sqlSession);
	}
	
}
