package org.iclass.finals;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;


@Component
//@RequiredArgsConstructor //@Value 로 int 값을 초기화 하기 위해 직접 작성
public class FinalProductDao {

	private final int count;
	
	public FinalProductDao(@Value("20") int count) {
		this.count=count;
	}
	
	public int product() {
		System.out.println("---- ProductDao product() 메소드 ----");
		System.out.println("----- 수량 : " + count + " 생산합니다.");
		return this.count;
	}
}
