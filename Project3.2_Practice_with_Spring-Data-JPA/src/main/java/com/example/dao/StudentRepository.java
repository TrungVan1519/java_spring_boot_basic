package com.example.dao; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// That's it ... No need to write any code 
}
