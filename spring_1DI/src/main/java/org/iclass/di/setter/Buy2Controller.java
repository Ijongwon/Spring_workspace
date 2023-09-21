package org.iclass.di.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Buy2Controller {
	
	//@Autowired			//필드 주입 : 스프링 권고 사항으로는 사용하지 않습니다.
	private Buy2Service service;

	public Buy2Controller(Buy2Service service) {
		System.out.println("::: Buy2Controller 커스텀 생성자 :::");
		this.service = service;
	}

	
	 public Buy2Controller() {
	 System.out.println("::: Buy2Controller 기본 생성자 :::"); }
	 
	@Autowired		//setter 주입에 필요한 애노테이션
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