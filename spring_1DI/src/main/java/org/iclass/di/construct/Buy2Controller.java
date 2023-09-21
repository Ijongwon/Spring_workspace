package org.iclass.di.construct;


import org.springframework.stereotype.Component;

@Component
public class Buy2Controller {
	
	
	private Buy2Service service;
	
	
	public Buy2Controller(Buy2Service service) {
	    System.out.println("::: Buy2Controller 커스텀 생성자 :::"); 
	    this.service = service;
	}
	 
	/*
	 * public Buy2Controller() {
	 * System.out.println("::: Buy2Controller 기본 생성자 :::"); }
	 */
	
	public void setService(Buy2Service service) {
		System.out.println("--- Buy2Controller 서비스 setter --- ");
		this.service = service;
	}
	
	public void buy() {
		System.out.println("--- Buy2Controller buy() 메소드 ---");
		service.buy();
	}
}
//@Component 어노테이션 : bean으로 만들어질 클래스 위에 설정합니다.즉 bean으로 만들어 줍니다.