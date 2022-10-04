package com.mphasis.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TouristInfoConsumer_Posting_JsonData implements CommandLineRunner {
	
	@Override
	public void run(String... args) throws Exception {
		
		// create rest template object
		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:7070/SpringRestProj14-ProviderApp-PathVariable-JSONData/wish/api/register"; // base url
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String json_content = "{\"tid\":1001,\"tname\":\"Mandana Travels\",\"startPlace\":\"Hyd\",\"destPlace\":\"Mumbai\"}";
		HttpEntity<String> request = new HttpEntity<String>(json_content, headers);
		
		//ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, request, String.class);
		
		System.out.println("response body:: "+response.getBody());
		System.out.println("response status code:: "+response.getStatusCode());
		System.out.println("response status value:: "+response.getStatusCodeValue());
		System.out.println("response headers:: "+response.getHeaders());
		System.out.println("======================================");
		
		
		
		
	}

}
