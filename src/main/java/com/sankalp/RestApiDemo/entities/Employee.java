package com.sankalp.RestApiDemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@GeneratedValue
	@Id
	private int emp_id;
	
	@Column(name = "name")
	private String name;
	
	public Employee() {

	}
	
	public Employee(int id, String name) {
		this.emp_id = id;
		this.name = name;
	}

	public int getId() {
		return emp_id;
	}

	public void setId(int id) {
		this.emp_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employ [id=" + emp_id + ", name=" + name + "]";
	}
}
