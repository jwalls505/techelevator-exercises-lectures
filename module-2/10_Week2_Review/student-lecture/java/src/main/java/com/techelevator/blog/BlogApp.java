package com.techelevator.blog;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.blog.model.PostDAO;
import com.techelevator.blog.model.jdbc.JDBCPostDAO;

public class BlogApp {

	private PostDAO sampleDAO = null;
	
	public static void main(String[] args) {
		BlogApp exerciseApp = new BlogApp();
		
		// TODO The rest of the application :-)
	}
	
	public BlogApp(){
		// Sample definition for a PostgreSQL database named "sample" hosted on localhost at port 5432
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/blog");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		// Create an instance of the SampleDAO
		sampleDAO = new JDBCPostDAO(dataSource);
	}

}
