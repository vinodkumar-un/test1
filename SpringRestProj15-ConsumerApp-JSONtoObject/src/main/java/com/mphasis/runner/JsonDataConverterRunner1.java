package com.mphasis.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mphasis.model.Politician;

//@Component
public class JsonDataConverterRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String serviceUrl = "http://localhost:7070/SpringRestProj15-ProviderApp-JSONtoObject/politician/api/report";

		ResponseEntity<String> responseEntity = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		System.out.println("===============List<T>==================");
		
		System.out.println("response body:: " + responseEntity.getBody());
		System.out.println("response statuc code:: " + responseEntity.getStatusCode());
		System.out.println("response headers:: " + responseEntity.getHeaders());
		
		System.out.println("===============JSON to Object conversion_List<T>==================");
		
		ObjectMapper mapper = new ObjectMapper();
		Politician politician[] = mapper.readValue(responseEntity.getBody(), Politician[].class);
		List<Politician> list = Arrays.asList(politician);
		list.forEach(System.out::println);
		System.out.println("JSON to Object Conversion:: " + politician);
		System.out.println("=================================");
		List<Politician> list1 = mapper.readValue(responseEntity.getBody(), new TypeReference<List<Politician>>() {});
		list1.forEach(System.out::println);
	}

}
