package org.iclass;


import org.springframework.stereotype.Component;

@Component
public class ProductService {
	
	private ProductDao dao;			
	
	//3) setter 주입을 위해서 기본생성자 정의
	/*	// 생성자 주입 일때는 기본생성자 주석처리
	 * public ProductService() {
	 * System.out.println("::::: ProductService 생성자 ::::"); }
	 */

	
	public void setDao(ProductDao dao) {
		System.out.println("---- ProductService setter 메소드 ----");
		this.dao = dao;
	}
	
	//2)생성자 주입
	  //3)setter 주입할 때 주석처리
	public ProductService(ProductDao dao) {
		System.out.println("::::: ProductService 생성자 - ProductDao bean 주입 :::");
		this.dao=dao;
	}
	
	public void product() {
		System.out.println("---- ProductService product() 메소드 ----");
		dao.product();
	}
}
