package org.iclass.java;

public class JavaMain {

	public static void main(String[] args) {
		

		//기존의 객체를 new 연산으로 직접 생성하는 예시
		//컨트롤러가 가장 앞단에서 요청 처리하는 경우로 예시
		BuyDao dao = new BuyDao("JDBC");
		
		System.out.println("::::: 1. setter 메소드로 의존관계를 설정 :::::");
		//1)dao객체를 service 가 사용하게 합시다. : 방법 1)setter 메소드로 전달하기 2)생성자로 전달하기   
		BuyService service = new BuyService();
		service.setDao(dao);
		
		//2)service 객체를 controller 가 사용
		BuyController controller = new BuyController();
		controller.setService(service);
		controller.buy();		//최종 실행 목표
		
		System.out.println("\n");
		BuyDao dao2 = new BuyDao("mybatis");
		System.out.println("::::: 2. 커스텀 생성자로 의존관계를 설정 :::::");
		BuyService service2 = new BuyService(dao2);
		BuyController controller2 = new BuyController(service2);
		controller2.buy();			//최종 실행 목표

	}
//스프링에서는 1),2) 에 해당하는 의존객체 설정을 자동으로 합니다. 1) 생성자 주입(커스텀생성자)  2) setter 주입 3) 필드 주입
}


