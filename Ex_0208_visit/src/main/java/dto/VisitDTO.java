package dto;

import lombok.Data;

@Data
public class VisitDTO {
	private int index;
	private String name, content, pwd, ip, regdate;
}
