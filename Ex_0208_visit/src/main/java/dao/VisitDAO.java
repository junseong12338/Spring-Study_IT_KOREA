package dao;

import java.util.HashMap;
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
	
	public int delete(HashMap<String, Object> map) {
		return sqlSession.insert("visit.visit_delete",map);
	}
	
	public VisitDTO selectOne(int idx){
		return sqlSession.selectOne("visit.visit_one",idx);
	}
	
	public int update(VisitDTO dto) {
		return sqlSession.update("visit.visit_update",dto);
	}
}