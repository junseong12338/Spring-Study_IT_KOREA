package com.korea.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BoardDAO;
import dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import util.Common;
import util.Page;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	final BoardDAO boardDAO;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value = {"/","board_list"})
	public String list(Model model, @RequestParam(required = false, defaultValue = "1") int page) {

		int start = (page-1) * Common.Board.BLOCKLIST + 1;
		int end = start + Common.Board.BLOCKLIST - 1;

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start",start);
		map.put("end",end);
		
		//������ ��ȣ�� ���� ��ü �Խñ� ��ȸ
		List<BoardDTO> list = boardDAO.selectList(map);
		
		
		// ��ü �Խù� �� ��ȸ
		int rowTotal = boardDAO.getRowTotal();
		//������ �޴� �����ϱ�
		String pageMenu = Page.getPaging("board_list",page,rowTotal,Common.Board.BLOCKLIST,Common.Board.BLOCKPAGE);
		
		// ���ΰ�ħ ��ȸ�� ���� ���� ���ǻ��
		request.getSession().removeAttribute("show");
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		return Common.Board.VIEW_PATH+"board_list.jsp?page="+page;
	}
	
	
}
