package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dao.DeptDAO;
import dto.DeptDTO;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class DeptController implements WebMvcConfigurer {

public static final String VIEW_PATH = "/WEB-INF/views/dept/";
	
	//dao에 대한 정보가 필요하기 때문에 이미 만들어놓은 정보를 주입해야 한다.
	final DeptDAO dept_dao;
		
	@RequestMapping(value= {"/","/list"})
	public String list(Model model) {
		
		List<DeptDTO> list = dept_dao.selectList();
		
		model.addAttribute("list",list);
		return VIEW_PATH + "dept_list.jsp";
	}
	

}