package org.iclass.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProductService {
	
	private MyProductDao dao;
	
	/*
	 * public ProductService(ProductDao dao) {
	 * System.out.println("$$$ 서비스 커스텀 생성자 $$$"); this.dao = dao;
	 * 
	 * }
	 */
	
	public MyProductService() {
		System.out.println(" $$$ 서비스 기본 생성자 $$$ ");
		
	}
	
	@Autowired
	public void setDao(MyProductDao dao) {
		System.out.println("$$$ 서비스 다오 setter $$$ ");
		this.dao = dao;
	}
	
	public void product() {
		System.out.println("$$$ 서비스 product() 메소드 $$$ ");
		dao.product();
	}
	
}
