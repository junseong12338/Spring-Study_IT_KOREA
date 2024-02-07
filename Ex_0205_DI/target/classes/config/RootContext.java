package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.BoardDAOImpl;
import service.BoardServiceImpl;


// 스프링에게 현재 클래스가 설정파일임을 알려주는 어노테이션
@Configuration
public class RootContext {

	@Bean
	public BoardDAOImpl boardDAOImpl() {
		return new BoardDAOImpl();
	}
	

	
}
