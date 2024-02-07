package com.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.MyPath.HomeClass;

@Controller
public class ParamController {
	@RequestMapping(value= {"/","/insert_form"}) 
	public String insert_form() {
		return HomeClass.VIEW_PATH + "insert_form.jsp";
	}
}
