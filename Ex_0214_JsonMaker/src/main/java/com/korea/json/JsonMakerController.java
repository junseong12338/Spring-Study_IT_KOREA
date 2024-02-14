package com.korea.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	
	@RequestMapping("/map_to_json")
	@ResponseBody
	public HashMap<String,Object> mapToJson(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name","��浿");
		map.put("age", "20");
		
		HashMap<String,String> tel_map = new HashMap<String, String>();
		tel_map.put("home", "032-1111-1111");
		tel_map.put("cell", "010-2222-2222");
		
		map.put("tel",tel_map);
		
		return map;
	}
	
	@RequestMapping("/list_to_json")
	@ResponseBody
	public List<PersonDTO> listTojson(){
		
		List<PersonDTO> list = new ArrayList<PersonDTO>();
		
		PersonDTO p1 = new PersonDTO();
		p1.setName("ȫ�浿");
		p1.setAge(30);
		p1.setAddr("��õ�� ����");
		
		PersonDTO p2 = new PersonDTO();
		p2.setName("��浿");
		p2.setAge(20);
		p2.setAddr("��õ�� ��籸");
		
		list.add(p1);
		list.add(p2);
		
		return list;
		
	}
}
