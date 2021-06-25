package com.sankalp.RestApiDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankalp.RestApiDemo.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
