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
	
	
	public BoardDTO selectOne (int idx) {
		return  sqlSession.selectOne("b.board_one", idx);
	}
	
	public int update_readhit(int idx) {
		return sqlSession.update("b.update_readhit",idx);
	}
	
	// �Խñ� �߰�
	public int insert(BoardDTO dto) {
		return sqlSession.insert("b.board_insert",dto);
	}
	
	//����߰�
	public int reply(BoardDTO dto) {
		int res = sqlSession.insert("b.board_reply",dto);
		return res;
	}

	
	//����߰��� ���� step+1
	public int update_step(BoardDTO dto) {
		int res = sqlSession.update("b.board_update_step",dto);
		return res;
	}
	
	// �Խñ� ����
	public int del(int idx) {
		return sqlSession.delete("b.board_delete",idx);
	}
}
