package com.techelevator.dao_example.model;

import java.util.List;

public interface CityDAO {
	List<City> getAll();
	
	City getById(int id);
	
	void update(City city);
}
