package org.iclass;

import org.iclass.dao.CommunityMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MybatisApp {

	public static void main(String[] args) {
		ApplicationContext context =
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
		
		CommunityMapper dao =
				context.getBean(CommunityMapper.class);
		
		//CommunityMapper 는 인터페이스인데 우리가 구현체를 직접 정의하지 않았으므로 정체를 확인하는 코드
		log.info("CommunityMapper bean 의 클래스 이름 - {}",dao.getClass().getName());
		
		((AbstractApplicationContext) context).close();
	}

}