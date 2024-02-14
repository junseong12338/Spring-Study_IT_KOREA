package com.korea.visit;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dao.VisitDAO;
import dto.VisitDTO;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class VisitController implements WebMvcConfigurer {

public static final String VIEW_PATH = "/WEB-INF/views/visit/";
	
	//dao에 대한 정보가 필요하기 때문에 이미 만들어놓은 정보를 주입해야 한다.
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
	
	//새 글 작성
	@RequestMapping("insert")
	public String insert(VisitDTO dto, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		dto.setIp(ip);
		
		String webPath = "/resources/upload/";
		String savePath =  request.getServletContext().getRealPath(webPath);

				
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
		int res = visit_dao.insert(dto);
		 
		if(res > 0) return "redirect:list"; 
		
		return null; 
	}
	
	// 글삭제
	// Ajax로 정보를 보낼떄 @ResponseBody를 
	// 붙여야함 실행 결과가 콜백메서드를 활용한 현재 페이지 이기 떄문에 더이상 viewName을 반환하면 안됨
	@RequestMapping("delete")
	@ResponseBody // return 값을 view 형태로 인식하지 않고 콜백메서드로 전달하기 위한 어노테이션
	public String delete(int idx, String pwd) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("pwd", pwd);
		int res = visit_dao.delete(map);

		String result="no";

		if( res == 1) {
			result="yes";
		}

		String finRes= String.format("[{'res':'%s'}]",result);
		
		return finRes;
	}
	
	@RequestMapping("modify_form")
	public String modify_form(Model model, int idx) {

		//파라미터로 넘어온 idx를 DB로 보낸다.
		VisitDTO dto = visit_dao.selectOne(idx);
		model.addAttribute("dto",dto);
		return VIEW_PATH+"visit_modify_form.jsp";
	}
	@RequestMapping("modify")
	public String modify(VisitDTO dto, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		dto.setIp(ip);

		

		int res = visit_dao.update(dto);

		return "redirect:list";
	}
	
	
}