package com.resttemplate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resttemplate.v2.dto.Employee;

@RestController
@RequestMapping("employees/v2")
public class EmployeeControllerV2 {
	Map<Long, Employee> employeeMap = new HashMap();
	
	@PostConstruct
	public void initEmployees() {
		employeeMap.put(1L, new Employee(1L, "John", "Nguyen"));
		employeeMap.put(2L, new Employee(2L, "Peter", "Phan"));
		employeeMap.put(3L, new Employee(3L, "Mike", "Dao"));
	}
	
	@GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE)
	public Map<Long, Employee> getEmployees() {
		return employeeMap;
	}
	
	@RequestMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeMap.get(id);
	}
	
	@PostMapping(value = "/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employeeMap.put(employee.getId(), employee);
		return employeeMap.get(employee.getId());
	}
}
