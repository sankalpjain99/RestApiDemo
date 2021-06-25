package com.sankalp.RestApiDemo.controllers;

import java.util.List;
import java.util.Optional;

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

import com.sankalp.RestApiDemo.entities.Employee;
import com.sankalp.RestApiDemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/empRestApi")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int id){
		Optional<Employee> emp = employeeRepository.findById(id);
		if(!emp.isPresent()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(emp.get());
	}
	
	@PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
	
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") int id, @RequestBody Employee employeeDetails){
		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employee.isPresent()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		Employee foundEmployee = employee.get();
		foundEmployee.setName(employeeDetails.getName());
		Employee updatedEmployee = employeeRepository.save(foundEmployee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable(value="id") int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(!employee.isPresent()) {
			return new ResponseEntity<Boolean>(true, HttpStatus.NOT_FOUND);
		}
		employeeRepository.delete(employee.get());
		return ResponseEntity.ok(true);
	}
	
}
