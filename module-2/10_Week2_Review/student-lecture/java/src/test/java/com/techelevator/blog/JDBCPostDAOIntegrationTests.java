package com.techelevator.blog;

import org.junit.Before;

import java.util.List;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.Assert;

import com.techelevator.blog.model.Post;
import com.techelevator.blog.model.jdbc.JDBCPostDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCPostDAOIntegrationTests extends BlogIntegrationTests {
	private JDBCPostDAO dao;
	
	@Before
	public void setup() {
		dao = new JDBCPostDAO(dataSource);
		
		// 1. clear the table of all data
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String truncatePosts = "TRUNCATE TABLE post_comments, post";
		jdbcTemplate.update(truncatePosts);
	}
	
	@Test
	public void getAllPosts_returns_stuff() {
		// Arrange
		// 2. add new posts
//		String insertPost = "INSERT INTO post (user_id, title, content) VALUE (?, ?, ?)";
//		
//		jdbcTemplate.update(insertPost, , , ,);
//		jdbcTemplate.update(insertPost, , , ,);
		
		Post objectToInsert = new Post();
		objectToInsert.setTitle("Some Title");
		
		dao.createPost(objectToInsert);
		dao.createPost(objectToInsert);
		
		// Act
		// 1. get all the posts
		List<Post> allPosts = dao.getAllPosts();
		
		// Assert
		// 1. make sure they're not null
		Assert.assertNotNull(allPosts);
		// 2. make sure i have the correct number of posts
		Assert.assertEquals(2, allPosts.size());
		// 3. test the data inside of the posts are accurate
		assertPostsAreEqual(objectToInsert, allPosts.get(0));
		assertPostsAreEqual(objectToInsert2, allPosts.get(1));
	}
	
	private void assertPostsAreEqual(Post expected, Post actual) {
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getTitle(), actual.getTitle());
	}
	
}
