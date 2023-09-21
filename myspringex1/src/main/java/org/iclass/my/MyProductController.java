package org.iclass.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProductController {

	private MyProductService service;
	
	public MyProductController(MyProductService service) {
		System.out.println("@@@ 컨트롤러 커스텀 생성자 @@@");
		this.service = service;
	}
	
	public MyProductController() {
		System.out.println("@@@ 컨트롤러 기본 생성자 @@@");
	}
	
	@Autowired
	public void setService(MyProductService service) {
		System.out.println("@@ 컨트롤러 서비스 setter @@");
		this.service = service;
	}
	
	public void product() {
		System.out.println("@@ 컨트롤러 product 메소드 @@");
		service.product();
	}
}
