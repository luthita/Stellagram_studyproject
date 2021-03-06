package com.luthita.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luthita.comment.bo.CommentBO;
import com.luthita.comment.model.Comment;
import com.luthita.post.bo.LikeBO;
import com.luthita.post.bo.PostBO;
import com.luthita.post.model.Post;
import com.luthita.timeline.model.Content;

@Service
public class ContentBO {
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private CommentBO commentBO;
	
	@Autowired
	private LikeBO likeBO;
	
	public List<Content> getContentList(Integer userId) {
		List<Content> contentList = new ArrayList<>();
		
		// Post 목록
		List<Post> postList = postBO.getPostList();
		for (Post post : postList) {
			Content content = new Content();
			content.setPost(post);
			
			// Post의 댓글 - Comment 목록
			List<Comment> commentList = commentBO.getCommentList(post.getId());
			content.setCommentList(commentList);

			// Post의 좋아요 - Like
			content.setFilledLike(likeBO.existLike(post.getId(), userId));
			
			// Post의 좋아요 수 - Like
			content.setLikeCount(likeBO.getLikeCountByPostId(post.getId()));
			
			contentList.add(content);
		}
		
		return contentList;
	}
}
