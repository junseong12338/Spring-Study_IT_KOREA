package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.BoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardDAO {
	
	final SqlSession sqlSession;

	//페이지별로 게시글 조회
	public List<BoardDTO> selectList(HashMap<String, Integer> map){
		List<BoardDTO> list = sqlSession.selectList("b.board_list", map);
		return list;
	}

	//전체 게시물 수 조회
	public int getRowTotal() {
		int count = sqlSession.selectOne("b.board_count");
		return count;
	}
}
