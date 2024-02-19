package dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import context.Context_2_dao;
//JUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션
//톰캣 대신에 스프링에 접근할 수 있게 해준다.
@RunWith(SpringJUnit4ClassRunner.class)
//설정 파일을 읽어야 하는데, 이런 설정파일을 로드하는 어노테이션이 ContextConfiguration이다.
@ContextConfiguration(classes= {Context_2_dao.class})
//println 대신에 쓸 로그 객체를 생성합니다.
@Log4j
public class DependencyTest {
	
	@Autowired
	private Coding coding;

	//Test에 사용될 메서드임을 알려주는 어노테이션
	@Test
	public void check() {
		log.info("----------------");
		log.info("coding : " + coding);
		log.info("computer : " + coding.getComputer());
		log.info("----------------");
	}
	

}