package com.mphasis.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class DeleteTouristRunner implements CommandLineRunner {
	
	
	@Override
	public void run(String... args) throws Exception {
		
		// create rest template object
				RestTemplate template = new RestTemplate();
				String serviceUrl = "http://localhost:7070/SpringRestProj13-ProviderApp-PathVariable-JSONData/wish/api/delete/{id}"; // base url
				template.delete(serviceUrl, Map.of("id", 1010));
				System.out.println("delete operation is completed");
				
		
	}

}
