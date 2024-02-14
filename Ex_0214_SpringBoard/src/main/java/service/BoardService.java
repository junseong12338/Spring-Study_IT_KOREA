package service;

import java.util.HashMap;
import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardService {

	
	final BoardDAO boardDAO;

	public HashMap<String, Object> selectList(HashMap<String, Integer> map) {
		
		HashMap<String ,Object> selectMap = new HashMap();
		
		List<BoardDTO> list = boardDAO.selectList(map);
		
		int rowTotal = boardDAO.getRowTotal();
		
		selectMap.put("list", list);
		selectMap.put("rowTotal", rowTotal);
		
		return selectMap;
		
	}

			
}
