package dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int idx; //�� ��ȣ
	private int readhit; //��ȸ��
	private int ref; //������ ��ȣ
	private int step; //����
	private int depth; //��� ����
	private int del_info; //��������
	
	/// 
	private String name; //�ۼ���
	private String subject; //����
	private String content; //����
	private String pwd; //��й�ȣ
	private String  ip; //ip
	private String regdate; //�ۼ���¥
}
