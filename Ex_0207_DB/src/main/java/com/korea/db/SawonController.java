package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dao.SawonDAO;
import dto.SawonDTO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SawonController implements WebMvcConfigurer {
	public static final String VIEW_PATH2 = "/WEB-INF/views/sawon/";
	
	final SawonDAO sawon_dao;
	
	@RequestMapping(value= {"/sawon","/sawon"})
	public String list(Model model) {
		List<SawonDTO> list = sawon_dao.selectList();
		model.addAttribute("list",list);
		return VIEW_PATH2 + "sawon_list.jsp";
	}
}
