package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDAO;
import com.example.entity.Student;
 
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public Student findById(int theId) {
		return studentDAO.findById(theId);
	}

	@Override
	public void addOrUpdate(Student theStudent) {
		studentDAO.addOrUpdate(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentDAO.deleteById(theId);
	}

}
