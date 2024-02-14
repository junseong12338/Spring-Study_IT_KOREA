package com.korea.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.PersonDTO;

@Controller
public class JsonMakerController {
	
	
	@RequestMapping("/dto_to_json")
	@ResponseBody
	public PersonDTO dtoToJson() {
		PersonDTO p1 = new PersonDTO();
		p1.setName("ȫ�浿");
		p1.setAge(30);
		p1.setAddr("��õ�� ����");
		
		return p1;
	}
	
}
