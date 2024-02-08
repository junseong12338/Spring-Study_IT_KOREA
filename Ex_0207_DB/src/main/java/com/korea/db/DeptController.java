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
	
	//dao�� ���� ������ �ʿ��ϱ� ������ �̹� �������� ������ �����ؾ� �Ѵ�.
	final DeptDAO dept_dao;
		
	@RequestMapping(value= {"/","/list"})
	public String list(Model model) {
		
		List<DeptDTO> list = dept_dao.selectList();
		
		model.addAttribute("list",list);
		return VIEW_PATH + "dept_list.jsp";
	}
	

}