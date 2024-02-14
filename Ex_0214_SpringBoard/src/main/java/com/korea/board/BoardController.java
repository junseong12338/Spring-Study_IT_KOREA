package com.korea.board;

import org.springframework.stereotype.Controller;

import dao.BoardDAO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	final BoardDAO board_dao;

	
	
}
