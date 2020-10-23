package com.techelevator.projects.model.jdbc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
	

	public JDBCProjectDAO(DataSource dataSource) { 
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		LocalDate currentDate = LocalDate.now();
		List<Project> activeProjects = new ArrayList<>();
		String getActiveProjectsQry = "SELECT project_id, name, from_date, to_date FROM project "+
									  "WHERE from_date IS NOT NULL AND ? >= from_date AND (? <= to_date OR to_date IS NULL)";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(getActiveProjectsQry, currentDate, currentDate);	
		while(rowSet.next()) {
			long project_id = rowSet.getLong("project_id");
			String name = rowSet.getString("name");
			Date from_Date = rowSet.getDate("from_date");
			Date toDate = rowSet.getDate("to_date");
			
			Project myProject = new Project();
			myProject.setId(project_id);
			myProject.setName(name);
			if(from_Date != null) {
				myProject.setStartDate(from_Date.toLocalDate());
			}
			if(toDate != null) {
				myProject.setEndDate(toDate.toLocalDate());

			}
			activeProjects.add(myProject);
		}
		return activeProjects;	
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmployee = "DELETE FROM project_employee "+
								   "WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sqlRemoveEmployee, projectId, employeeId);
								   
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmployee = "INSERT INTO project_employee(project_id, employee_id) "+
								"VALUES(?, ?)";
		
		jdbcTemplate.update(sqlAddEmployee, projectId, employeeId);
		
	}



}
