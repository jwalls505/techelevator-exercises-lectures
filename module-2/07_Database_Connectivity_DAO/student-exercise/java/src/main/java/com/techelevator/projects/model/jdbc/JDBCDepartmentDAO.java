package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> theDepartments = new ArrayList<>();
		String selectAllDepartments = "SELECT department_id, name FROM department";
		jdbcTemplate.queryForRowSet(selectAllDepartments);	
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(selectAllDepartments);
		while(rowSet.next()) {
			Department selectDepartment = mapRowToDepartment(rowSet);
			theDepartments.add(selectDepartment);
		}
		return theDepartments;	
	} 

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> theDepartments = new ArrayList<>();
		String selectDepartmentName = "SELECT department_id, name FROM department "+
									  "WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectDepartmentName, nameSearch);
		while(results.next()) {
			Department departmentByName = mapRowToDepartment(results);
			theDepartments.add(departmentByName);
			
		}
		return theDepartments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlInsertDepartment = "UPDATE department "+
									 "SET name = ? "+
				   					 "WHERE department_id = ?";
		jdbcTemplate.update(sqlInsertDepartment, updatedDepartment.getName(), updatedDepartment.getId());			  
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name) "+
									 "VALUES(?, ?)";
		newDepartment.setId(getNextDepartmentID());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());

		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department theDepartmentsById = null;
		String selectDepartmentId = "SELECT department_id, name "+
									"FROM department "+
									"WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectDepartmentId, id);
		if(results.next()) {
			 theDepartmentsById = mapRowToDepartment(results);
			
		}
		return theDepartmentsById;	
	}
	
	
	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department theDepartment = new Department();
		theDepartment.setId(rowSet.getLong("department_id"));
		theDepartment.setName(rowSet.getString("name"));
		return theDepartment;
	}
	private long getNextDepartmentID() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}
}
