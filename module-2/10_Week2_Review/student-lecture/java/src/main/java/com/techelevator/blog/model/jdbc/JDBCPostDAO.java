package com.techelevator.blog.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.blog.model.Post;
import com.techelevator.blog.model.PostDAO;

public class JDBCPostDAO implements PostDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCPostDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Post> getAllSamples() {
		// TODO 
		return null;
	}

	@Override
	public Post getSampleByID(long id) {
		// TODO 
		return null;
	}

	@Override
	public Post getSampleByName(String name) {
		// TODO 
		return null;
	}

	@Override
	public Post createSample(long id, String name) {
		// TODO 
		return null;
	}

	@Override
	public Post updateSample(long id, String name) {
		// TODO 
		return null;
	}

	@Override
	public void removeSampleByID(long id) {
		// TODO 
	}

}
