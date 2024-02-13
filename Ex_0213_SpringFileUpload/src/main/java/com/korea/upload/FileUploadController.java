package com.korea.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {
	
	static final String VIEW_PATH = "/WEB-INF/views/";

	
	@RequestMapping(value= {"/","/insert_form"})
	public String isnert_form() {
		return VIEW_PATH+"insert_form.jsp";

	}
}
