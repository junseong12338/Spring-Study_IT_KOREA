package com.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/test/";

	public TestController() {
		System.out.println("----TestController�� ������ ȣ��---");
	}
	
	@RequestMapping("/test") //���� url�� test.do�� ȣ���ϸ�
	public String test(Model model) { //test()�޼��尡 ������ �ȴ�.
		
		String[] msg = {"���","�ٳ���","������","����","����"};
		
		model.addAttribute("msg",msg);//���ε�
		return VIEW_PATH + "test.jsp"; //WEB-INF/views/�� �ִ� test.jsp�� ���������
	
	}
}