package com.korea.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import dto.DeptDTO;

@Controller
public class TestController {
	 public TestController() {
		 System.out.println("-----TestController의 생성자-----");
	}
	 
	 @Autowired
	 DeptDAO deptDAO;
	 
	 @RequestMapping(value= {"/","list"})
	 public String dept_list(Model model) {
		 List<DeptDTO> list = deptDAO.selectList();
		 model.addAttribute("list",list);
		 return "/WEB-INF/views/dept_list.jsp";
	 }
	 
}
