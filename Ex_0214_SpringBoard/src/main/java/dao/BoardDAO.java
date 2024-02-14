package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.BoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDAO {
	
	final SqlSession sqlSession;

	//���������� �Խñ� ��ȸ
	public List<BoardDTO> selectList(HashMap<String, Integer> map){
		List<BoardDTO> list = sqlSession.selectList("b.board_list", map);
		return list;
	}

	//��ü �Խù� �� ��ȸ
	public int getRowTotal() {
		int count = sqlSession.selectOne("b.board_count");
		return count;
	}
}
