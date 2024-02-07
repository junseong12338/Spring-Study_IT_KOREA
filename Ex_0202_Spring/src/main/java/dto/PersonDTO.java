package dto;



//@Data
public class PersonDTO {
	private String name;
	private int age;
	
	public PersonDTO() {
		System.out.println("---PersonDTO의 기본생성자---");
	}
	
	public PersonDTO(String name, int age) {
		System.out.println("---파라미터를 받는 PersonDTO 생성자 호출 ----");
		this.name = name;
		this.age = age;
	}

	
	public void setName(String name) {
		System.out.println("name setter호출");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("age setter호출");
		this.age = age;
	}
	
}
