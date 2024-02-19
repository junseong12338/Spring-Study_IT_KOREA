package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import dto.DeptDTO;
import dto.SawonDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SawonDAO {
	
	final SqlSession sqlSession;
	 public List<SawonDTO> selectList(){
		   	List<SawonDTO> list = sqlSession.selectList("sawon.sawon_list");
		   	return list;
	   }
}
