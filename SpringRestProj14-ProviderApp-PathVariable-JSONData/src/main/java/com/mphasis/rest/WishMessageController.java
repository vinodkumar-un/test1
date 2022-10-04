package com.mphasis.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.model.Tourist;

@RestController
@RequestMapping("/wish/api")
public class WishMessageController {
	
	@GetMapping("/report")
	public ResponseEntity<String> showWishMessage() {
		return new ResponseEntity<String>("Good Evng", HttpStatus.OK);
	}

	@GetMapping("/message/{id}/{name}")
	public ResponseEntity<String> showWishMessage(@PathVariable("id") int id, @PathVariable("name") String name) {
		System.out.println("id: "+id+" name: "+name);
		return new ResponseEntity<String>("Good Afternoon :: " + id + " name:: " + name, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {
		System.out.println("WishMessageController.registerTourist()"+tourist.toString());
		return new ResponseEntity<String>("tourist info:: "+tourist.toString(), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable("id") int tid) {
		return new ResponseEntity<String>(tid+" Tourist deleted", HttpStatus.OK);
	}

}
