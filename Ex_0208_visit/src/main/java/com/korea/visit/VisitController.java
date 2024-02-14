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
	
	//dao�� ���� ������ �ʿ��ϱ� ������ �̹� �������� ������ �����ؾ� �Ѵ�.
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
	
	//�� �� �ۼ�
	@RequestMapping("insert")
	public String insert(VisitDTO dto, HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		dto.setIp(ip);
		
		String webPath = "/resources/upload/";
		String savePath =  request.getServletContext().getRealPath(webPath);

				
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
		int res = visit_dao.insert(dto);
		 
		if(res > 0) return "redirect:list"; 
		
		return null; 
	}
	
	// �ۻ���
	// Ajax�� ������ ������ @ResponseBody�� 
	// �ٿ����� ���� ����� �ݹ�޼��带 Ȱ���� ���� ������ �̱� ������ ���̻� viewName�� ��ȯ�ϸ� �ȵ�
	@RequestMapping("delete")
	@ResponseBody // return ���� view ���·� �ν����� �ʰ� �ݹ�޼���� �����ϱ� ���� ������̼�
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

		//�Ķ���ͷ� �Ѿ�� idx�� DB�� ������.
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