package com.korea.di;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class Coding {
	
	// �ʵ� ����
	// @Autowired
	// Computer computer;
	
	//  @setter
	//  setter����
	//	public void setComputer(Computer computer){
	//		this.computer = computer;
	//	}
	
	// @RequiredArgsConstructor
	// ���������� final Computer computer;
	// public Coding(Computer computer){
	//		this.computer = computer;
	// }
	
	
	final Computer computer;

	
	

	
	
	

}