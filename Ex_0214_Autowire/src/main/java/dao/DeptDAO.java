package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.DeptDTO;

@Repository("deptDAO") //dept_dao : 현재 DeptDAO를 자동생성하기 위한 별칭
public class DeptDAO {

	// 생성자 호출 시점 
	// 객체가 생성될 때
	public DeptDAO() {
		System.out.println("-----deptDAO 생성자의 호출-----");
	}
	
	@Autowired
	SqlSession sqlSession;
	
	
	// 전체 부서 조회
	public List<DeptDTO> selectList(){
		return sqlSession.selectList("d.dept_list");
	}
}
