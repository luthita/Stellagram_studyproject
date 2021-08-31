package com.luthita.timeline.model;

import java.util.List;

import com.luthita.comment.model.Comment;
import com.luthita.post.model.Post;

public class Content {
	private Post post;
	private boolean filledLike;
	private int likeCount;
	private List<Comment> commentList;
	
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	public boolean isFilledLike() {
		return filledLike;
	}
	public void setFilledLike(boolean filledLike) {
		this.filledLike = filledLike;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
