package com.techexpert.mysqldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techexpert.mysqldemo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
