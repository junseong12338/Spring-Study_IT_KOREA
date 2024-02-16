package com.korea.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TestDAO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	final TestDAO testDAO;
	
	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	@RequestMapping(value = {"/", "test"})
	public String test() {
		testDAO.test();
		
		return VIEW_PATH+"test.jsp";
	}
}
