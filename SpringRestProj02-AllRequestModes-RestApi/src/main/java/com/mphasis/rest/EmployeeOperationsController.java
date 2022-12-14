package com.mphasis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {

	@GetMapping("/all")
	public ResponseEntity<String> getAllEmployees() {
		System.out.println("EmployeeOperationsController.getAllEmployees()");
		return new ResponseEntity<String>("GET Mapping -- Fetching all employees", HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> registerEmployee() {
		System.out.println("EmployeeOperationsController.registerEmployee()");
		return new ResponseEntity<String>("POST Mapping -- saving the employee", HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee() {
		System.out.println("EmployeeOperationsController.updateEmployee()");
		return new ResponseEntity<String>("PUT Mapping -- updating the employee", HttpStatus.OK);
	}
	
	@PatchMapping("/patch")
	public ResponseEntity<String> patchEmployee() {
		System.out.println("EmployeeOperationsController.patchEmployee()");
		return new ResponseEntity<String>("PATCH Mapping -- updating the employee partially", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee() {
		System.out.println("EmployeeOperationsController.deleteEmployee()");
		return new ResponseEntity<String>("DELETE Mapping -- delete the employee", HttpStatus.OK);
	}

}
