package service;

import java.util.List;

import dao.BoardDAOImpl;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{


	final BoardDAOImpl board_dao;
	
	
	
	@Override
	public List<Object> selectList() {
		
		return board_dao.selectList();
	}
}
