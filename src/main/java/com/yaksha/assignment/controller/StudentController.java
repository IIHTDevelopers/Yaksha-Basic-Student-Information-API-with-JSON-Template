package com.yaksha.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assignment.dto.Student;

@RestController
public class StudentController {

	@GetMapping("/student")
	public Student getStudent() {
		// Hardcoded student data
		return new Student("John Doe", 20, "Computer Science");
	}
}
