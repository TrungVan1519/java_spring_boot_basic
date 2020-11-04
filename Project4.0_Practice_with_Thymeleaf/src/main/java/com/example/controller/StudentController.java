package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Student;
import com.example.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	// get student
	@GetMapping("/list-student")
	public String listStudent(Model model) {
		
		model.addAttribute("listStudent", studentService.findAll());
		return "/student-view/list-student-view";
	}
	
	@GetMapping("/single-student/{studentId}")
	public String showSingleStudent(
			Model model, 
			@PathVariable int studentId) {
		
		model.addAttribute("singleStudent", studentService.findById(studentId));
		return "/student-view/single-student-view";
	}
	
	// add student
	@GetMapping("/show-adding-form")
	public String showAddingForm(Model model) {
		
		model.addAttribute("student", new Student());
		return "/student-view/adding-form-view";
	}

	@PostMapping("/saving-student")
	public String addStudent(@ModelAttribute("student") Student theStudent) {
		
		// save the student
		studentService.addOrUpdate(theStudent);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list-student";
	}
	
	// update student
	@GetMapping("/show-updating-form/{studentId}")
	public String showUpdatingForm(
			Model model,
			@PathVariable int studentId) {
		
		model.addAttribute("student", studentService.findById(studentId));
		return "/student-view/updating-form-view";
	}
	
	@PostMapping("/updating-student")
	public String updateStudent(@ModelAttribute Student student) {

		// update student
		studentService.addOrUpdate(student);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list-student";
	}
	
	// delete student
	@GetMapping("/deleting-student/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		
		// delete student
		studentService.deleteById(studentId);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list-student";
	}
}
