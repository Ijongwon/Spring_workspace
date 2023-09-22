package org.iclass.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.iclass.config.MybatisConfig;
import org.iclass.dto.Community;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@DisplayName("CommunityMapper 구현체 생성확인합니다.")
//spring의 test클래스 설정
@ExtendWith(SpringExtension.class)			//테스트 클래스 기능을 위한 어노테이션
//@ContextConfiguration(locations ="classpath:MET-A-INF/spring/applicationContext.xml" )
@ContextConfiguration(classes = MybatisConfig.class)		//테스트 클래스에서 설정파일 가져오기
@Slf4j
class CommunityMapperTest {
	
	@Autowired				//테스트 코드에서 필드 주입
	private ApplicationContext context;
	
	@Autowired
	private CommunityMapper dao;
	
	@DisplayName("context, dao bean 생성 확인합니다.")	//설명
	@Test
	//@Disabled			 //테스트에서 제외할 때 쓰는 어노테이션
	void bean() {
		log.debug("mapper 인터페이스의 구현체 - {}",dao.getClass().getName());
		assertNotNull(context);
		assertNotNull(dao);
	}
	
	
	@DisplayName("list 로 가져온 개수와 count 함수 결과는 같아야 합니다.")
	@Test
	//@Disabled
	void list() {
		List<Community> list  = dao.list();
		int size = list.size();
		int count = dao.count();
		log.info("select 전체 크기 : {} , select count : {}",size, count);
		
		assertEquals(count, size);
	}
	@DisplayName("insert 입니당")
	@Test
	@Disabled
	void insert() {
		Community dto = 
				Community.builder().writer("박상현").title("박상현 일대기").content("저 멋있쬬").ip("127.0.0.1").build();
		dao.insert(dto);
		
		log.debug("insert 성공");
	}
	
}
