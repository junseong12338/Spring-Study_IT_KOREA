package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PhotoDTO {	
	private String title; 
	private String filename; // 실제 파일이름
	private MultipartFile photo; // 바이너리 파일 정보
}
