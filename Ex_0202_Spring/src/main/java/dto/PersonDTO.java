package dto;



//@Data
public class PersonDTO {
	private String name;
	private int age;
	
	public PersonDTO() {
		System.out.println("---PersonDTO�� �⺻������---");
	}
	
	public PersonDTO(String name, int age) {
		System.out.println("---�Ķ���͸� �޴� PersonDTO ������ ȣ�� ----");
		this.name = name;
		this.age = age;
	}

	
	public void setName(String name) {
		System.out.println("name setterȣ��");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("age setterȣ��");
		this.age = age;
	}
	
}