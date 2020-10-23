package com.techelevator.projects.model.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class jdbdcprojectDAOintegrationtests {
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
	private JDBCEmployeeDAO daoEmployee;
	private static final String TEST_PROJECT = "Secret Ninja File";
	
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() { 
		Date from_date = Date.valueOf("1953-03-01");
		Date to_date = Date.valueOf("2020-12-01");
		String sqlInsertProject = "INSERT INTO project (project_id, name, from_date, to_date) Values(13, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertProject, TEST_PROJECT, from_date, to_date);
		dao = new JDBCProjectDAO(dataSource);
		daoEmployee = new JDBCEmployeeDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	@Test
	public void get_all_active_projects() {
		List<Project> results = dao.getAllActiveProjects();
		Assert.assertNotNull(results);
		Assert.assertEquals(3, results.size());
	
		
	}
	@Test
	public void test_add_and_remove_employee_to_project() {
		Long employeeID = daoEmployee.getAllEmployees().get(0).getId();
		Long projectID = dao.getAllActiveProjects().get(1).getId();
		int numBeforeAddingEmployee = daoEmployee.getEmployeesByProjectId(projectID).size();
		
		dao.addEmployeeToProject (projectID, employeeID);
		Assert.assertEquals(numBeforeAddingEmployee + 1 , daoEmployee.getEmployeesByProjectId(projectID).size());
		dao.removeEmployeeFromProject(projectID, employeeID);
		Assert.assertEquals(numBeforeAddingEmployee, daoEmployee.getEmployeesByProjectId(projectID).size());
		
	} 
	/*@Test
	public void test_remove_employee_from_project() {
		List<Project> results = dao.getAllActiveProjects();
		Long employeeID = daoEmployee.getAllEmployees().get(0).getId();
		Long projectID = dao.getAllActiveProjects().get(1).getId();
		int counter = daoEmployee.getEmployeesByProjectId(projectID).size();
		dao.removeEmployeeFromProject(projectID, employeeID);
		Assert.assertEquals(counter, daoEmployee.getEmployeesByProjectId(projectID).size());
		
		
	}*/
}
