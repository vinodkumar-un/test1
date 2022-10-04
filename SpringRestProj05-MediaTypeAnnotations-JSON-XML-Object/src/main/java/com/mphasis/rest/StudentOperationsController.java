package com.mphasis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Student;

@RestController
@RequestMapping("/student/api")
public class StudentOperationsController {
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		System.out.println("StudentOperationsController.registerStudent()");
		if(!student.isVaccinated())
			student.setVaccinated(false);
		
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}

}
