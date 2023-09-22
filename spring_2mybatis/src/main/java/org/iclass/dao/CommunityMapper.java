package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.dto.Community;

							// 인터페이스는 객체를 생성할 수 없다. 구현클래스(구현체)가 필요하다.
//@Mapper					// 이 애노테이션은 mybatis mapper  인터페이스 ->  프록시가 구현체 만들어 줍니다.
public interface CommunityMapper {

	int insert(Community vo);
	int update(Community vo);
	int delete(long idx);
	Community selectByIdx(long idx);
	int count();
	long setReadCount();
	long commentsCount(long mref);
	int maxOf();
	List<Community> list();
}
