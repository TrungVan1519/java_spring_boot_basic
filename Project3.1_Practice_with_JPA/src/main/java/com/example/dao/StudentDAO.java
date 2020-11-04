package com.example.dao; 

import java.util.List;

import com.example.entity.Student;

public interface StudentDAO {

	List<Student> findAll();
	
	Student findById(int theId);
	
	void addOrUpdate(Student theStudent);
	
	void deleteById(int theId);
}
