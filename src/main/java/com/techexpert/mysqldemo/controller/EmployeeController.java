package com.techexpert.mysqldemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techexpert.mysqldemo.model.Employee;
import com.techexpert.mysqldemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository emprepo;

	@GetMapping
	public List<Employee> getEmployees() {
		return emprepo.findAll();

	}

	@GetMapping("/{id}")
	public Employee getemployeeById(@PathVariable(value = "id") Integer id) {
		Optional<Employee> findById = emprepo.findById(id);
		return findById.get();

	}
	
	@PostMapping
	public void saveEmployee(@RequestBody Employee employee) {
		if(employee != null && employee.getDept() != null) {
			emprepo.save(employee);
		}
		//TODO : add exception handling
			
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(value="id")Integer id) {
		emprepo.deleteById(id);
	}
	

}
