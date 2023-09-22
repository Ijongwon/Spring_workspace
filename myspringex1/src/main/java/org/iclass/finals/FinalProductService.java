package org.iclass.finals;


import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor // 커스텀 생성자 : 필드 초기화
public class FinalProductService {
	
	private final FinalProductDao dao;			//자동 주입 필드는 final . -> 커스텀 생성자로 초기화
	

	public int product() {
		System.out.println("---- ProductService product() 메소드 ----");
		int result = dao.product();
		System.out.println("&& dao result : " + result + "&&");
		return result;
	}
}
