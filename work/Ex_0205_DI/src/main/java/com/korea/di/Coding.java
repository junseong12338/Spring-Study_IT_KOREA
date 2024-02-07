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
	
	// 필드 주입
	// @Autowired
	// Computer computer;
	
	//  @setter
	//  setter주입
	//	public void setComputer(Computer computer){
	//		this.computer = computer;
	//	}
	
	// @RequiredArgsConstructor
	// 생성자주입 final Computer computer;
	// public Coding(Computer computer){
	//		this.computer = computer;
	// }
	
	
	final Computer computer;

	
	

	
	
	

}
