package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {

	List<Student> findAll();
	
	Student findById(int theId);
	
	void addOrUpdate(Student theStudent);
	
	void deleteById(int theId);
}
