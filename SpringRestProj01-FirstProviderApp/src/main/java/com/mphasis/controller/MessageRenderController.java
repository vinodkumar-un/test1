package com.mphasis.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi")
public class MessageRenderController {

	@GetMapping("/wish")
	public ResponseEntity<String> showMessage() {

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		String msg = null;
		int hour = ldt.getHour();
		if (hour < 12) {
			msg = "Good Morning";
		} else if (hour < 16) {
			msg = "Good Afternoon";
		} else if (hour < 18) {
			msg = "Good Evening";
		} else
			msg = "Good Night";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
