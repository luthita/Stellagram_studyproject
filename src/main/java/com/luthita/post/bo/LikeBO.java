package com.luthita.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luthita.post.dao.LikeDAO;

@Service
public class LikeBO {

	@Autowired
	private LikeDAO likeDAO;
	
	public void like(int postId, int userId) {
		boolean existLike = existLike(postId,userId);
		if(existLike) {
			likeDAO.deleteLike(postId, userId);
		} else {
			likeDAO.insertLike(postId, userId);
		}
	}
	
	
	public boolean existLike(int postId, Integer userId) {
		// 로그인 안했을때는 좋아요 X
		if(userId == null) {
			return false;
		}
		int count = likeDAO.selectLikeCountByPostIdOrUserId(postId,userId);
		return count > 0 ? true : false;
	}
	
	public int getLikeCountByPostId(int postId) {
		return likeDAO.selectLikeCountByPostIdOrUserId(postId, null);
	}
	
}
