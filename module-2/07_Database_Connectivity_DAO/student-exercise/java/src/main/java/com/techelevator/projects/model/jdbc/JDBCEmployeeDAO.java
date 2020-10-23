package com.techelevator.projects.model.jdbc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> theEmployee = new ArrayList<>();
		String selectAllEmployee = "SELECT * FROM employee";
		jdbcTemplate.queryForRowSet(selectAllEmployee);
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectAllEmployee);
		while (rowSet.next()) {
			Employee selectEmployee = mapRowToEmployee(rowSet);
			theEmployee.add(selectEmployee);
		}
		return theEmployee;
	} 

	@Override 
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> theEmployee = new ArrayList<>();
		String selectEmployeeByName = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date, gender FROM employee WHERE employee.first_name = ? AND last_name = ?";;
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectEmployeeByName, firstNameSearch, lastNameSearch);
		while (rowSet.next()) {
			Employee selectEmployee = mapRowToEmployee(rowSet);
			theEmployee.add(selectEmployee);

		}
		return theEmployee;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> theEmployee = new ArrayList<>();
		String selectEmployeeByName = "SELECT * "+
									  "FROM employee "+
									  "INNER JOIN department ON department.department_id = employee.department_id "+
									  "WHERE employee.department_id IS NOT NULL AND employee.department_id = ? "+
									  "ORDER BY employee.employee_id";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectEmployeeByName, id);
		while (rowSet.next()) {
			Employee selectEmployee = mapRowToEmployee(rowSet);
			theEmployee.add(selectEmployee);

		}
		return theEmployee;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> theEmployee = new ArrayList<>();
		String selectEmployeeByName = "SELECT * "+
									  "FROM employee "+
									  "WHERE employee.employee_id NOT IN(SELECT employee_id FROM project_employee)";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectEmployeeByName);
		while (rowSet.next()) {
			Employee selectEmployee = mapRowToEmployee(rowSet);
			theEmployee.add(selectEmployee);

		}
		return theEmployee;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> theEmployee = new ArrayList<>();
		String selectEmployeeByName = "SELECT * FROM employee "+
									  "INNER JOIN project_employee ON project_employee.employee_id = employee.employee_id "+
									  "WHERE project_employee.project_id = ?";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectEmployeeByName, projectId);
		while (rowSet.next()) {
			Employee selectEmployee = mapRowToEmployee(rowSet);
			theEmployee.add(selectEmployee);

		}
		return theEmployee; 
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String changeEmployeeDepart = "UPDATE employee "+
									  "SET department_id = ? "+
									  "WHERE employee_id = ?";
		jdbcTemplate.update(changeEmployeeDepart, departmentId, employeeId);

	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {

		Employee theEmployee = new Employee();
		theEmployee.setId(rowSet.getLong("employee_id"));
		theEmployee.setFirstName(rowSet.getString("first_name"));
		theEmployee.setDepartmentId(rowSet.getLong("department_id"));
		theEmployee.setLastName(rowSet.getString("last_name"));
		theEmployee.setBirthDay(rowSet.getDate("birth_date").toLocalDate());
		theEmployee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		theEmployee.setGender(rowSet.getString("gender").charAt(0));
		return theEmployee;
	}

}
