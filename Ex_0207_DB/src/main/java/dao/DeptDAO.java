package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.DeptDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeptDAO {
	final SqlSession sqlSession;
	
	
	public List<DeptDTO> selectList(){
		return sqlSession.selectList("dept.dept_list");
	}
}



// https://github.com/NKLCWDT/cs/tree/main/Spring
