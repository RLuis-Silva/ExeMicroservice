package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.valueObject.Department;
import com.example.valueObject.ResponseTemplateValueObject;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplateValueObject getUserWithDepartment(Long userId) {
		ResponseTemplateValueObject vo = new ResponseTemplateValueObject();
		User user = userRepository.findByUserId(userId);
		
		// ?
		Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmenId() , Department.class );
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
}
