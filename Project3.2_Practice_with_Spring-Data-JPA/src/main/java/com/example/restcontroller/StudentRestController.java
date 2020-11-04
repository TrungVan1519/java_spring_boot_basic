package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> showListStudent(){
		
		return studentService.findAll();
	}
	
	@GetMapping("/students/{studentId}")
	public Student showStudent(@PathVariable int studentId) {
		
		return studentService.findById(studentId);
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		
		student.setId(0);
		studentService.addOrUpdate(student);
		
		return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentService.addOrUpdate(student);
		return student;
	}
 
	@PutMapping("/students/{studentId}")
	public Student updateStudent(@PathVariable int studentId,
								 @RequestBody Student student){
		
		studentService.findById(studentId);
		student.setId(studentId);
		studentService.addOrUpdate(student);
		
		return student;
	}
	
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		studentService.findById(studentId);
		studentService.deleteById(studentId);
		
		return "Deleted student with id: " + studentId;
	}
}
