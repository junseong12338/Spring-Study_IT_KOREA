package dao;

import org.apache.ibatis.session.SqlSession;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestDAO {

	final SqlSession sqlSession;
	public void test() {
		System.out.println("-- call TestDAO.test()---");
	}
	
}
