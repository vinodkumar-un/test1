package com.mphasis.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Company;
import com.mphasis.model.Employee;

@RestController
@RequestMapping("/company/api")
public class CompanyOperationsController {

	@GetMapping("/show")
	public ResponseEntity<Map<String, Company>> showCompanyDetails() {

		Map<String, Company> map = new HashMap<>();
		map.put("empObj", new Company("mphasis", "hyd", 34000, 50000000.0, "IT"));
		return new ResponseEntity<Map<String, Company>>(map, HttpStatus.PARTIAL_CONTENT);
	}

	@GetMapping("/show/emp")
	public ResponseEntity<Map<String, Employee>> showEmployeeDetails() {

		Map<String, Employee> map = new HashMap<>();
		Company company = new Company("mphasis", "hyd", 34000, 50000000.0, "IT");
		Employee employee = new Employee(1001, "vinod", new String[] { "red", "green", "blue" },
				List.of("chinnu", "bannu"), Set.of(8978898665L, 86754467L),
				Map.of("panNo", 8676889676L, "aadhar", 867568956L), true,
				LocalDateTime.of(LocalDate.of(1992, 10, 06), LocalTime.of(06, 6, 8)), company);
		 map.put("empObj", employee);
		return new ResponseEntity<Map<String, Employee>>(map, HttpStatus.OK);
	}

}
