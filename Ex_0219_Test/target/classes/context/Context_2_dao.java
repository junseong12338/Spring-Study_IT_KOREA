package context;


import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dao.DeptDAO;



// ���������� ���� Ŭ������ ������������ �˷��ִ� ������̼�
@Configuration
@ComponentScan("dao")
public class Context_2_dao {

}
