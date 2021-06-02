package com.hcl.service;

import java.util.List;

import com.hcl.beans.Employee;
import com.hcl.exception.EmployeeException;

public interface IEmployeeService {

	public List<Employee> displayAllEmployee();

	public Employee addEmployee(Employee employee);

	public Employee getSingleEmployeeById(int id) throws EmployeeException;

	public Employee updateEmployee(Employee employee) throws EmployeeException;

	public void deleteEmployeeById(int id) throws EmployeeException;

}
