package com.example.dao; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entity.Student;

@RepositoryRestResource(path = "lanSauTheNaoCungSai")
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// That's it ... No need to write any code 
}
