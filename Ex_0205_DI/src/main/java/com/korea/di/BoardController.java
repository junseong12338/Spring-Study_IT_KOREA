package com.korea.di;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImpl;

@Controller
public class BoardController {
	
BoardServiceImpl service;
	
	public BoardController(BoardServiceImpl service) {
		this.service = service;
	}
	
	@RequestMapping("/board/list")
	public String select(Model model) {
		//서비스를 통해 dao의 selectList()메서드를 호출할 수 있다.
		List<Object> list = service.selectList();
		
		model.addAttribute("list",list);
		
		return "board_list";
	}
}