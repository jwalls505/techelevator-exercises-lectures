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
import com.techelevator.projects.model.Employee;

public class jdbcemployeeDAOintegrationtest {

	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private JDBCDepartmentDAO daoDepartment;
	private JDBCProjectDAO daoProject;
	private static final String TEST_EMPLOYEE_LAST_NAME = "Richie";
	private static final String TEST_EMPLOYEE_FIRST_NAME = "LIONEL";

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void destroyDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		Date birth_date = Date.valueOf("1949-07-20");
		Date hire_date = Date.valueOf("2020-04-10");
		String sqlInsertEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) VALUES (13, 3, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertEmployee, TEST_EMPLOYEE_FIRST_NAME, TEST_EMPLOYEE_LAST_NAME, birth_date, "M",hire_date);
		dao = new JDBCEmployeeDAO(dataSource);
		daoProject = new JDBCProjectDAO(dataSource);
		daoDepartment = new JDBCDepartmentDAO(dataSource);
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void test_Get_All_Employee() {
		List<Employee> results = dao.getAllEmployees();
		Assert.assertNotNull(results);
		Assert.assertEquals(13, results.size());
	}

	@Test
	public void getEmployeeByDepartmentId_gets_list_of_employees_for_rd() {
		List<Employee> testEmployee = dao.getAllEmployees();
		// Act
		List<Employee> employeeInRD = dao.getEmployeesByDepartmentId(3L);

		// Assert
		Assert.assertNotNull(testEmployee);
		Assert.assertEquals(6, employeeInRD.size());
	}

	@Test
	public void test_search_employees_by_name() {
		List<Employee> results = dao.searchEmployeesByName(TEST_EMPLOYEE_FIRST_NAME, TEST_EMPLOYEE_LAST_NAME);

		Assert.assertNotNull(results);
		Assert.assertEquals(TEST_EMPLOYEE_FIRST_NAME, results.get(0).getFirstName());
		Assert.assertEquals(TEST_EMPLOYEE_LAST_NAME, results.get(0).getLastName());
	}

	@Test
	public void test_get_employee_without_projects() {
		List<Employee> results = dao.getEmployeesWithoutProjects();
		Assert.assertNotNull(results);
		Assert.assertEquals(3, results.size());
	}
	@Test 
	public void test_get_employees_by_projectId() {
		List<Employee> results = dao.getEmployeesByProjectId(daoProject.getAllActiveProjects().get(0).getId());
		Assert.assertNotNull(results);
		Assert.assertEquals(3, results.size());
	}

	

	@Test
	public void change_employee_department_moves_employee_to_sales() {
		// ARRANGE
		Department myDepartment = getDepartment("Sales");
		daoDepartment.createDepartment(myDepartment);

		Employee employeeOne = dao.getAllEmployees().get(0);

		// ACT
		dao.changeEmployeeDepartment(employeeOne.getId(), myDepartment.getId());
		List<Employee> employeesInNewDepartment = dao.getEmployeesByDepartmentId(myDepartment.getId());
		Assert.assertNotNull(employeesInNewDepartment);
		Assert.assertEquals(1,employeesInNewDepartment.size());
		Employee employeeOneInNewDepartment = employeesInNewDepartment.get(0);
		Assert.assertEquals(employeeOne.getFirstName(),employeeOneInNewDepartment.getFirstName());
			
		}
	
	
	

	public Department getDepartment(String name) {
		Department theDepartment = new Department();
		theDepartment.setName(name);
		return theDepartment;
	}
}
