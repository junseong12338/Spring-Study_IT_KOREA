package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.SawonDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SawonDAO {
	final SqlSession sqlSession;
	
	public List<SawonDTO> selectList(){
		return sqlSession.selectList("s.sawon_list");
	}
	
}
