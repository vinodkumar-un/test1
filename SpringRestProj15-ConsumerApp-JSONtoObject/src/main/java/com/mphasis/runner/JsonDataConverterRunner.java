package com.mphasis.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mphasis.model.Politician;

//@Component
public class JsonDataConverterRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String serviceUrl = "http://localhost:7070/SpringRestProj15-ProviderApp-JSONtoObject/politician/api/find/{id}";

		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.GET, null, String.class,
				Map.of("id", 111));

		System.out.println("response body:: " + responseEntity.getBody());
		System.out.println("response statuc code:: " + responseEntity.getStatusCode());
		System.out.println("response headers:: " + responseEntity.getHeaders());
		System.out.println("=================================");

		ObjectMapper mapper = new ObjectMapper();
		Politician politician = mapper.readValue(responseEntity.getBody(), Politician.class);
		System.out.println("JSON to Object Conversion:: " + politician);

	}

}
