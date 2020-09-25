package com.techelevator;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	private double annualSalary;
	
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}
	
	public void  setLastName(String lname) {
			this.lastName = lname;
		}
	public void setDepartment(String depart) {
		this.department = depart;
	}
	public String getFullName() {
		return this.fullName = lastName + ", " + firstName;
	}
	
	public Employee(int employeeId, String firstName, String lastName, double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = salary;
	}
	
	
	public void raiseSalary(double percent) {
		annualSalary = annualSalary + (annualSalary * percent) / 100;
		
	}
}
