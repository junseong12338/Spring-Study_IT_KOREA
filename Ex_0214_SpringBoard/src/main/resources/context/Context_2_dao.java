package context;


import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.BoardDAO;
import service.BoardService;

//  스프링에게 현재 클래스가 설정파일임을 알려주는 어노테이션
@Configuration
public class Context_2_dao {
	@Bean
	public BoardDAO boardDAO(SqlSession sqlSession) {
		return new BoardDAO(sqlSession);
	}
	
	@Bean
	public BoardService boardService(BoardDAO boardDAO) {
		return new BoardService(boardDAO);
	}
}
