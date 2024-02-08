package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.VisitDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VisitDAO {
	
	final SqlSession sqlSession;
	
	
	public List<VisitDTO> selectList(){
		return sqlSession.selectList("visit.visit_list");
	}
	
	public int insert(VisitDTO dto) {
		return sqlSession.insert("visit.visit_insert",dto);
	}
}