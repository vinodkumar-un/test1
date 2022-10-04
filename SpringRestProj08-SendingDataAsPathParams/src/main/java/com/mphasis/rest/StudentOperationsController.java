package com.mphasis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentOperationsController {

	@GetMapping("/report/{sname}")
	public ResponseEntity<String> showReport(@RequestParam("sno") Integer sno, @PathVariable(name="sname") String sname) {
		System.out.println("sno: " + sno + " sname: " + sname);
		return new ResponseEntity<String>("sno: " + sno + " sname: " + sname, HttpStatus.OK);
	}

}
