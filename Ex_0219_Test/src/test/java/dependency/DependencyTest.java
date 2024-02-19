package dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import context.Context_2_dao;
//JUnit �����ӿ�ũ�� �׽�Ʈ �������� Ȯ���� �� ����ϴ� ������̼�
//��Ĺ ��ſ� �������� ������ �� �ְ� ���ش�.
@RunWith(SpringJUnit4ClassRunner.class)
//���� ������ �о�� �ϴµ�, �̷� ���������� �ε��ϴ� ������̼��� ContextConfiguration�̴�.
@ContextConfiguration(classes= {Context_2_dao.class})
//println ��ſ� �� �α� ��ü�� �����մϴ�.
@Log4j
public class DependencyTest {
	
	@Autowired
	private Coding coding;

	//Test�� ���� �޼������� �˷��ִ� ������̼�
	@Test
	public void check() {
		log.info("----------------");
		log.info("coding : " + coding);
		log.info("computer : " + coding.getComputer());
		log.info("----------------");
	}
	

}