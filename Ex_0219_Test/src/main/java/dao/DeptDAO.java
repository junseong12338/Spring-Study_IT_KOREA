package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import dto.DeptDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeptDAO {
	final SqlSession sqlSession;

	   public List<DeptDTO> selectList(){
	   	List<DeptDTO> list = sqlSession.selectList("dept.dept_list");
	   	return list;
	   }
}
