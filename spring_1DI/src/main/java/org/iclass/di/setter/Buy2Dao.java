package org.iclass.di.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Buy2Dao {
	
	@Value("마이바티스")
	private String dbFactory ;		
	
	/*
	 * public Buy2Dao(String dbFactory) {
	 * System.out.println("::::: Buy2Dao 커스텀 생성자  :::::"); this.dbFactory=dbFactory;
	 * }
	 */
	
	public Buy2Dao() { System.out.println("::::: Buy2Dao 기본 생성자  :::::"); }
	 
	@Value("Mybatis")
	public void setDbFactory(String dbFactory) {
		System.out.println("--- Buy2Dao String setter --- ");
		this.dbFactory = dbFactory;
	}
	
	public void buy() {
		System.out.println("--- Buy2Dao buy() 메소드 ---");
		System.out.println(dbFactory + "를 이용하여 db에 연결합니다.");
	}

}
