package com.techelevator.dao_example.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.dao_example.model.City;
import com.techelevator.dao_example.model.CityDAO;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<City> getAll() {
		String getAllCities = "SELECT * FROM city";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(getAllCities);
		
		List<City> cities = new ArrayList<City>();
		
		while(rowSet.next()) {
			// parse results into City object
			City myCity = new City();
			
			int id = rowSet.getInt("id");
			myCity.setId(id);
			
			myCity.setName(rowSet.getString("name"));
			
			cities.add(myCity);
		}
		
		return cities;
	}

	@Override
	public City getById(int id) {
		String getAllCities = "SELECT * FROM city WHERE id = ?";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(getAllCities, id);
		
		City myCity = new City();
		
		if(rowSet.next()) {
			myCity.setId(rowSet.getInt("id"));
			myCity.setName(rowSet.getString("name"));
		}
		
		return myCity;
	}

	@Override
	public void update(City city) {
		String updateCity = "UPDATE city "
				+ "SET name = ?, "
				+ "population = ?, "
				+ "district = ?, "
				+ "countrycode = ? "
				+ "WHERE id = ?";
		
		jdbcTemplate.update(updateCity, city.getName(), 
				city.getPopulation(), city.getDistrict(), 
				city.getCountrycode(), city.getId());
		
	}

}
