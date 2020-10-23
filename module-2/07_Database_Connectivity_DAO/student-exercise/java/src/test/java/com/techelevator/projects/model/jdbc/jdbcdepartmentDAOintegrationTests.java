package com.techelevator.projects.model.jdbc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;


public class jdbcdepartmentDAOintegrationTests {
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private static final String TEST_DEPARTMENT = "Global Division";
	
	
	@BeforeClass
	public static  void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static  void destroyDataSource() throws SQLException {
		dataSource.destroy(); 
	}
	
	@Before
	public void setup() {
		String sqlInsertDepartment = "INSERT INTO department (department_id, name) Values(10, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDepartment, TEST_DEPARTMENT);
		dao = new JDBCDepartmentDAO(dataSource);
	}
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_all_departments() {
		List<Department> results = dao.getAllDepartments();
		assertNotNull(results);
		assertEquals(6, results.size());
		
	}
	@Test
	public void test_search_department_by_name() {
		Department testDepart = new Department();
		testDepart.setName("World Domination");
		dao.createDepartment(testDepart);
		List<Department> departments = dao.searchDepartmentsByName(testDepart.getName());
		Assert.assertNotNull(departments);
		Assert.assertEquals(1, departments.size());
		assertDepartmentsAreEqual(testDepart, departments.get(0));
	}
	@Test
	public void test_create_department_and_read_by_id() {
		Department testDepart = new Department();
		testDepart.setName("World Domination");
		dao.createDepartment(testDepart);
		Department readDepartById = dao.getDepartmentById(testDepart.getId());
		Assert.assertNotEquals(null, readDepartById);
		assertDepartmentsAreEqual(testDepart, readDepartById);
		
	}
	@Test
	public void test_Save_Department() {
		Department myDepartment = getDepartment("World Domination");
		dao.createDepartment(myDepartment);
		myDepartment.setName("Licking Techniques");
		dao.saveDepartment(myDepartment);
		
		Department savedDepartment = dao.getDepartmentById(myDepartment.getId());
		assertNotNull(myDepartment);
		assertDepartmentsAreEqual(savedDepartment, myDepartment);
	}
	
	private void assertDepartmentsAreEqual(Department expected, Department actual) {
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getName(), actual.getName());
	}
	public Department getDepartment(String name) {
		Department theDepartment = new Department();
		theDepartment.setName(name);
		return theDepartment;
	}
}
