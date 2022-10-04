package com.mphasis.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.client.IBillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping/api")
public class ShoppingServiceOperationsController {

	// @Autowired
	// private BillingServiceConsumerClient client;

	@Autowired
	private IBillingServiceConsumerClient client;

	@GetMapping("/cart")
	public ResponseEntity<String> doShopping() {
		System.out.println("ShoppingServiceOperationsController.doShopping()" + " proxy classname: " + client.getClass()
				+ " --- " + Arrays.toString(client.getClass().getInterfaces()));
		// String resultMsg = client.getBillingInfo();
		String resultMsg = client.fetchBillingInfo().getBody();
		return new ResponseEntity<String>("Shopping the items(shirt, trouser) ::: " + resultMsg, HttpStatus.OK);
	}

}
