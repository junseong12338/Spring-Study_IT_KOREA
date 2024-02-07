package com.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.PersonDTO;
import util.MyPath.HomeClass;

@Controller
public class ParamController {
	
	@RequestMapping(value= {"/","/insert_form"}) 
	public String insert_form() {
		return HomeClass.VIEW_PATH + "insert_form.jsp";
	}
	
	
	@RequestMapping("/insert1")
	public String insert1(@RequestParam String name, 
						  @RequestParam String tel,
						  @RequestParam int age,
						  Model model) {
		
		PersonDTO dto = new PersonDTO();
		
		dto.setName(name);
		dto.setTel(tel);
		dto.setAge(age);
		
		model.addAttribute("dto",dto);
		return HomeClass.VIEW_PATH + "insert_result.jsp";
	}
	// @RequestParam("dto") 받을 수 없음
	@RequestMapping("/insert2")
	public String insert2(@ModelAttribute("dto") PersonDTO dto) {
		return HomeClass.VIEW_PATH + "insert_result.jsp";
	}
	
}
