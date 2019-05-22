package com.techexpert.mysqldemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techexpert.mysqldemo.model.Department;
import com.techexpert.mysqldemo.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository deprepo;
	
	@GetMapping
	public List<Department> getAllDepartment(){
		return deprepo.findAll();
	}
	
	@PostMapping
	public Department postDepartment(@RequestBody Department department) {
		
		if(department != null) {
			return deprepo.save(department);
			
		}
		return null;
		
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable(value="id") Integer id) {
		Optional<Department> findById = deprepo.findById(id);
		return findById.get();
	}

}
