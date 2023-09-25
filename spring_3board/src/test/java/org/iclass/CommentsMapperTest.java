package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.iclass.mvc.dao.CommunityCommentsMapper;
import org.iclass.mvc.dto.CommunityComments;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
class CommentsMapperTest {

	@Autowired
	CommunityCommentsMapper dao;
	
	
	@DisplayName("메인글 203번 - 댓글 리스트가 있습니다.")
	@Test
	void selectList() {
		List<CommunityComments> list = dao.commentsList(203L);
		log.info("203번 댓글 리스트는 : {}" , list);
		list.forEach(item -> {
			log.info("item : {}" , item);
			
		});
		assertNotNull(list);
	}

	

}
