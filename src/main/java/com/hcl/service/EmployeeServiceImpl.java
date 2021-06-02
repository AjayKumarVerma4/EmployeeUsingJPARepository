package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.beans.Employee;
import com.hcl.dao.IEmployeeDAO;
import com.hcl.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO iEmployeeDAO;

	// display list of all employee
	@Override
	public List<Employee> displayAllEmployee() {
		System.out.println("start method to display employee list")
		return iEmployeeDAO.findAll();
	}

	// add new employee
	@Override
	public Employee addEmployee(Employee employee){
		return iEmployeeDAO.saveAndFlush(employee);
	}

	// get single employee by id
	@Override
	public Employee getSingleEmployeeById(int id) throws EmployeeException{
		if(iEmployeeDAO.findById(id).isPresent())
			return iEmployeeDAO.findById(id).get();
		else
			throw new EmployeeException("employee does not exist");
	}

	// update employee
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException{
		if(iEmployeeDAO.findById(employee.getId()).isPresent()) {
		    return iEmployeeDAO.saveAndFlush(employee);
		}else {
			throw new EmployeeException("employee does not exist");
		}
	}

	// delete employee by id
	@Override
	public void  deleteEmployeeById(int id) throws EmployeeException{
		if(iEmployeeDAO.findById(id).isPresent())
		      iEmployeeDAO.deleteById(id);
		else
			throw new EmployeeException("employee already deleted");
	}

}
