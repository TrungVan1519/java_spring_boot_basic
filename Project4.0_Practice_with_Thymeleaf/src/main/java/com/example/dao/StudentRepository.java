package com.example.dao; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// That's it ... No need to write any code 
	
	// Add a method to sort by lastname
	List<Student> findAllByOrderByLastNameAsc();
}
