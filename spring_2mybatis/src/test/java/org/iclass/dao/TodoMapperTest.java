package org.iclass.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.ibatis.type.MappedTypes;
import org.iclass.config.MybatisConfig;
import org.iclass.dto.PageRequestDTO;
import org.iclass.dto.TodoDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@DisplayName("todo mapper 의 curd 동작이 되어야 합니다.")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MybatisConfig.class)
@Slf4j

public class TodoMapperTest {
	
	@Autowired
	private TodoMapper dao;
	
	@Test
	@DisplayName("insert 를 여러행 해봅시다. 페이징 테스트를 위한")
	@Disabled
	void insertMany() {
		IntStream.range(1, 20).forEach(i -> {
			TodoDto dto = TodoDto.builder()
			.dueDate(LocalDate.of(2023,10,3))
			.title("집에가고싶다." + i)
			.writer("박상현" + (char)('a'+i))
			.finished(true)
			.build();
			
			dao.insert(dto);}
			);
	}
	
	@Test
	@DisplayName("다양한 조건으로 검색합니다.")
	//@Disabled
	void search() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.of(1, 5,new String[] {"w"},"박상현",
				false,null,null);
		//PageRequestDTO pageRequestDTO = PageRequestDTO.of(1, 5,null,null,false,
				//LocalDate.of(2023, 9, 30),LocalDate.of(2023, 10, 3));
		List<TodoDto> list = dao.selectPageList(pageRequestDTO);
		list.forEach(dto -> log.info(">>>>> search result : {}" ,dto));
		log.info(">>>>>>>>>>> total count : {}",dao.getCount(pageRequestDTO));
	}
	
	
	@DisplayName("todo 테이블에 insert가 되어야 합니다.")
	@Test
	@Disabled
	void insert() {
		TodoDto dto = TodoDto.builder()
				.title("오늘 할일")
				.dueDate(LocalDate.of(2023,10,4))
				.writer("이종원")
				.build();
		log.info("dto : {}" ,dto);
		assertNotEquals(0, dao.insert(dto));
	}
	
	
	@Test
	@DisplayName("tno 1개를 조건값으로 조회가 되어야 합니다.")
	@Disabled
	void selectOne() {
		TodoDto dto = dao.selectOne(20114L);
		log.info(">>>>>> 조회된 dto : {}",dto);
		assertNotNull(dto);
	}
	

	
	
	
}
