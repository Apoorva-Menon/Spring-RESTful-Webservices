package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.DAOClasses.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao department;
	public List<Department> getAllDepartments() {
		
		return department.getAllDepartments();
	}

	
}