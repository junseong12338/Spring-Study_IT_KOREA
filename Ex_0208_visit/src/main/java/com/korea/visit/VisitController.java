package com.korea.visit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dao.VisitDAO;
import dto.VisitDTO;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class VisitController implements WebMvcConfigurer {

public static final String VIEW_PATH = "/WEB-INF/views/visit/";
	
	//dao�� ���� ������ �ʿ��ϱ� ������ �̹� �������� ������ �����ؾ� �Ѵ�.
	final VisitDAO visit_dao;
		
	@RequestMapping(value= {"/","/list"})
	public String list(Model model) {
		
		List<VisitDTO> list = visit_dao.selectList();
		
		model.addAttribute("list",list);
		return VIEW_PATH + "visit_list.jsp";
	}
	
	
	@RequestMapping("insert_form")
	public String insert_from() {
		return VIEW_PATH + "visit_insert_form.jsp";
	}
	
	//�� �� �ۼ�
	@RequestMapping("insert")
	public String insert(VisitDTO dto, HttpServletRequest request) {
		//insert.do?name=�ϱ浿&content=����&pwd=111
		String ip = request.getRemoteAddr();
		dto.setIp(ip);

		int res = visit_dao.insert(dto);
		 
		if(res > 0) return "redirect:visit_list"; 
		
		return null; 
	}
}