package org.iclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component

public class ProductDao {

	private int count;
	
	//3) 기본생성자 정의
	public ProductDao() {
		System.out.println("::::: ProductDao 기본 생성자 :::::");
	}
	
	//파라미터 타입이 bean(객체) 이 아니므로 자동 주입과정이 없습니다. 
	@Value("22")		//@Autowired 처럼 setter 동작을 합니다.
	public void setCount(int count) {		//파라미터에서 @Value 설정은 setter 동작 안합니다.
	System.out.println("---- ProductDao setter 메소드 ----"); 
	this.count = count; 
	}
	
	public ProductDao(int count) {
		System.out.println("::::: ProductDao 생성자 - int value 전달 :::");
		this.count=count;
	}
	
	public void product() {
		System.out.println("---- ProductDao product() 메소드 ----");
		System.out.println("----- 수량 : " + count + " 생산합니다.");
	}
}
