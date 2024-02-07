package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.BoardDAOImpl;
import service.BoardServiceImpl;


// ���������� ���� Ŭ������ ������������ �˷��ִ� ������̼�
@Configuration
public class RootContext {

	@Bean
	public BoardDAOImpl boardDAOImpl() {
		return new BoardDAOImpl();
	}
	

	
}
