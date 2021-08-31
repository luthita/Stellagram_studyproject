package com.luthita.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luthita.post.model.Post;

public interface PostDAO {
	public List<Post> selectPostList();
	
	public int insertPost(
			@Param("userId") Integer userId,
			@Param("userName") String userName,
			@Param("content") String content, 
			@Param("imagePath") String imagePath);
	
	public Post selectPost(int id);
	
	public void deletePost(int id); 	
}
