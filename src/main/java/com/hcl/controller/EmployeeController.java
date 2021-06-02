package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beans.Employee;
import com.hcl.exception.EmployeeException;
import com.hcl.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService iEmployeeService;
	
	@GetMapping("/displayAllEmployee")
	public ResponseEntity<List<Employee>> displayAllEmployees() {
		List<Employee> employeeList = iEmployeeService.displayAllEmployee();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
	
	@PostMapping("/addNewEmployee")
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
			Employee emp = iEmployeeService.addEmployee(employee);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/getSingleEmployee/{id}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable("id") int id) throws EmployeeException{
		Employee emp = iEmployeeService.getSingleEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws EmployeeException{
			Employee emp = iEmployeeService.updateEmployee(employee);
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) throws EmployeeException{
		iEmployeeService.deleteEmployeeById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
