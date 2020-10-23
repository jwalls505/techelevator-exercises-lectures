package com.techelevator.blog.model;

import java.time.LocalDate;
import java.util.List;

public interface PostDAO {

	public List<Post> getAllPosts();
	
	public Post getPostByID(long id);
	
	public List<Post> getPostsByUserID(long userId);
	
	public List<Post> getPostsInDateRange(LocalDate begin, LocalDate end);
	
	public Post createPost(Post post);
	
	public Post updatePost(Post post);
	
	public void removePostByID(long id);
}
