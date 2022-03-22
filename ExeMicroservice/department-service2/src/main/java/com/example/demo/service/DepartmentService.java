package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
//		log.info("dentro al metodo saveDepartment di DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
