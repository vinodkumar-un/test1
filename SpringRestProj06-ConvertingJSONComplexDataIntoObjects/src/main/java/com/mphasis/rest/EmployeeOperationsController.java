package com.mphasis.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Company;
import com.mphasis.model.Employee;

@RestController
@RequestMapping("/employee/api")
public class EmployeeOperationsController {

	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp) {

		Long aadharVal = emp.getIdDetails().get("aadhar");
		Map<String, Long> map = new HashMap<>();
		map.put("panNo", 6767563L);
		map.put("aadhar", aadharVal);
		emp.setIdDetails(map);

		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@PostMapping("/company")
	public ResponseEntity<Company> registerCompany(@RequestBody Company company) {
		System.out.println("EmployeeOperationsController.registerCompany()" + company);
		return new ResponseEntity<Company>(company, HttpStatus.CREATED);
	}

}
