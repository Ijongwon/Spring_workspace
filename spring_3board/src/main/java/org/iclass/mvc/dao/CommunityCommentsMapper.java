package org.iclass.mvc.dao;

import java.util.List;

import org.iclass.mvc.dto.CommunityComments;

public interface CommunityCommentsMapper {

	int insert(CommunityComments dto);
	int delete(long idx);
	long maxof();
	List<CommunityComments> commentsList(long idx);
	int setCommentCount(long idx);
	
}
