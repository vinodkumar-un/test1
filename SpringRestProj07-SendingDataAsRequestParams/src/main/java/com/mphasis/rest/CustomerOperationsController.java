package com.mphasis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/api")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam("sno") int no, @RequestParam String name) {
		System.out.println(no + " " + name);
		return new ResponseEntity<String>("no: " + no + " name: " + name, HttpStatus.OK);
	}
	
	@PostMapping("/report")
	public ResponseEntity<String> regReport(@RequestParam("sno") int no, @RequestParam String name) {
		System.out.println(no + " " + name);
		return new ResponseEntity<String>("no: " + no + " name: " + name, HttpStatus.OK);
	}

}
