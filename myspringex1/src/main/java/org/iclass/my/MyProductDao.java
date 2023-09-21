package org.iclass.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProductDao {

	private int count;
	
	public MyProductDao() {
		System.out.println("## 다오 기본 생성자 ##");
		
	}
	@Value("100")
	public void setCount(int count) {
		System.out.println("## 다오 setter 메소드 ##");
		this.count = count;
	}
	
	public MyProductDao(int count) {
		System.out.println("### 다오 생성자 ###");
		this.count=count;
		
	}
	
	public void product() {
		System.out.println("### 다오 product() 메소드 ###");
		System.out.println(" 수량 " + count + " 입니다 .");
		
	}
}
