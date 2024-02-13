package dto;

import lombok.Data;

@Data
public class VisitDTO {
	private int idx;
	private String name, content, pwd, ip, regdate;
}
