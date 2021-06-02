package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.beans.Employee;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {

}

