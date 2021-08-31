package com.luthita.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {

	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
	public void deleteLike(
			@Param("postId")int postId,
			@Param("userId")int userId);
	
	public int selectLikeCountByPostIdOrUserId(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
}
