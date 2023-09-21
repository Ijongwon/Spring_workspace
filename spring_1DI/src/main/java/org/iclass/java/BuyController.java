package org.iclass.java;

import lombok.Setter;

// MVC 모델에서는 Controller 에서 Service 객체를 사용하고 , Service 에서는 Dao 객체를 사용합니다.
//     * Controller -> Service -> Dao 의 순서로 `의존성을 갖는다`고 말합니다.
//     * 참고로 Controller 는 요청처리, Service는 업무(비지니스)로직, Dao 는 Sql 실행하는 역할을 합니다.	
public class BuyController {
	
	@Setter 
	private BuyService service;		
				//프로퍼티 변수가 클래스 타입 일때 의존관계가 생깁니다.
				//BuyService 객체를 사용하게 되므로 `의존관계가 있다` 고 표현 합니다.
	
//기본생성자 추가 : 기본 생성자 없는 연습도 해보세요.
	public BuyController() {
	}
	
	
//아직 아무 객체도 할당되지 않은 프로퍼티에 객체를 참조시키는 방법(즉 객체를 언제 참조시킬것이냐?) 
//2가지는  1) 생성자  2) setter 
//		* 객체를 할당하는(참조시키는) 것을  `의존관계 주입"(Dependency Injection, DI)` 이라고 합니다.
	public BuyController(BuyService service) {
		System.out.println(":::: BuyController 생성자 - BuyService 객체 주입:::::");
		this.service=service;		//객체 참조
	}

	public void buy() {
		System.out.println("~~~~ controller buy() ~~~~ ");
		service.buy();		//참조되는 객체가 없으면? service 변수는 null -> NullPointerException
	}
	
}
