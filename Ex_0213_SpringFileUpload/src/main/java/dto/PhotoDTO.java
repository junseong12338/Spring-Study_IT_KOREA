package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PhotoDTO {	
	private String title; 
	private String filename; // ���� �����̸�
	private MultipartFile photo; // ���̳ʸ� ���� ����
}
