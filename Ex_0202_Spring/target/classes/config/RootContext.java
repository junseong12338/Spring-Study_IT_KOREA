package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dto.PersonDTO;

//  ���������� ���� Ŭ������ ������������ �˷��ִ� ������̼�
@Configuration
public class RootContext {
	// Bean
	// Spring ���� Bean�� ���ø����̼��� �ٽ� ������ҷ� ����� �Ǵ� ��ü�� �ǹ��Ѵ�.
	// �������� ���� ���� (Inversion of Control, IoC)�� ���� ��ü�� �����ֱ��
	// ������ ������ �������� ����ϰ� �ȴ�.
	
	@Bean
	public PersonDTO p1() {
		PersonDTO p1 = new PersonDTO();
		p1.setName("ȫ�浿");
		p1.setAge(30);
		return p1;
	}
	
	@Bean
	public PersonDTO p2() {
		PersonDTO p2 = new PersonDTO("�̱浿",40);
		return p2;
	}
}
