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
				
		// 업로드된 파일의 정보
		MultipartFile photo = dto.getPhoto();
	
		String filename = "no_file";
		
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();

			// 파일을 저장할 경로 지정
			File saveFile = new File(savePath, filename);
			if(!saveFile.exists()) {
				// 폴더 생성
				saveFile.mkdirs();
			}else {
				
				// 동일한 이름의 파일을 경우 폴더 형태 변환 불가능 하므로
				// 업로드 시간을 붙여 이름 중복 방지
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename);
			}
			try {
				photo.transferTo(saveFile);
			}catch (Exception e) {}
		
		}
		
		request.setAttribute("dto", dto);
		dto.setFilename(filename); //dto.getPhoto();로 얻어온 파일정보에서 파일이름을 뽑아서 넣어주자
		return VIEW_PATH+"input_result.jsp";
		
	}
}
