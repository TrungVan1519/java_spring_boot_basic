package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentRepository;
import com.example.entity.Student;
 
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> optionalStudent = studentRepository.findById(theId);
		Student student = null;
		
		if(optionalStudent.isPresent()) {
			student = optionalStudent.get();
		} else {
			throw new RuntimeException("Student not found id: " + theId);
		}
		
		return student;
	}

	@Override
	public void addOrUpdate(Student theStudent) {
		studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

}
