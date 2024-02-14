package com.korea.upload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dto.PhotoDTO;

@Controller
public class FileUploadController {
	
	static final String VIEW_PATH = "/WEB-INF/views/";

	
	@RequestMapping(value= {"/","/insert_form"})
	public String isnert_form() {
		return VIEW_PATH+"insert_form.jsp";

	}
	
	@RequestMapping("upload")
	public String upload(PhotoDTO dto,HttpServletRequest request) {
		String webPath = "/resources/upload/";
		String savePath = "";
		ServletContext application = request.getServletContext();
		savePath = application.getRealPath(webPath);
				
		System.out.println(savePath);
				
		// ���ε�� ������ ����
		MultipartFile photo = dto.getPhoto();
	
		String filename = "no_file";
		
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();

			// ������ ������ ��� ����
			File saveFile = new File(savePath, filename);
			if(!saveFile.exists()) {
				// ���� ����
				saveFile.mkdirs();
			}else {
				
				// ������ �̸��� ������ ��� ���� ���� ��ȯ �Ұ��� �ϹǷ�
				// ���ε� �ð��� �ٿ� �̸� �ߺ� ����
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename);
			}
			try {
				photo.transferTo(saveFile);
			}catch (Exception e) {}
		
		}
		
		request.setAttribute("dto", dto);
		dto.setFilename(filename); //dto.getPhoto();�� ���� ������������ �����̸��� �̾Ƽ� �־�����
		return VIEW_PATH+"input_result.jsp";
		
	}
}
