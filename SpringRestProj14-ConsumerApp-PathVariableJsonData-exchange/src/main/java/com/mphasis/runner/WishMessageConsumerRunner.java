package com.mphasis.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class WishMessageConsumerRunner implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
		// create rest template object
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:7070/SpringRestProj13-ProviderApp-PathVariable-JSONData/wish/api/message/{id}/{name}"; // base url
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class, Map.of("id", 102, "name", "vinodkumar"));
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
	}

}
