package org.iclass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductApp {
//	private static final Logger logger = LoggerFactory.getLogger(ProductApp.class);

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(ProductConfig.class);
		
		ProductDao dao = context.getBean(ProductDao.class);
		dao.product();
		System.out.println("\n");
		ProductService service = context.getBean(ProductService.class);
		service.product();
		log.info("org.iclass 패키지의 로그 수준은 log4j.xml 에서 level 태그 값으로 설정합니다.");
//		log.debug("debug 메소드 실행은 org.iclass 패키지 로그 출력 수준이 degug 이하 일때 나옵니다.");
//		log.info("info 메소드 실행은 org.iclass 패키지 로그 출력 수준이 info 이하 일때 나옵니다.");
//		로그 레벨  trace -> debug -> info -> warn -> error
		
		((AbstractApplicationContext) context).close();
	}

}
