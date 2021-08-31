package com.luthita.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luthita.comment.model.Comment;

@Repository
public interface CommentDAO {

	public List<Comment> selectCommentList(int postId);
	
	public int insertComment(
			@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("postId") int postId,
			@Param("content") String content);
	
	public void deleteComment(int id);
	
}