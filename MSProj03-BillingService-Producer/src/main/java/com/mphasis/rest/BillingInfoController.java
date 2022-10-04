package com.mphasis.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class BillingInfoController {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/info")
	public ResponseEntity<String> fetchBillingDetails() {
		
		return new ResponseEntity<String>("Final Bill-Amt=Bill-Amt - Discount(5000) using port:: "+port+" instance id:: "+instanceId, HttpStatus.OK);
	}
	
	

}
