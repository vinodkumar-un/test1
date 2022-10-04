package com.mphasis.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class GetModeConsumerRunner1 implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
		// create rest template object
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:7070/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/report"; // base url
		
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		System.out.println(response.getStatusCodeValue());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
	}

}
