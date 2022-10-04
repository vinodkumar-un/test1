package com.mphasis.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class BillingServiceConsumerClient {
	
	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo() {
		// Getting service though DiscoveryClient
		//List<ServiceInstance> listInstances = client.getInstances("billing-service");
		//ServiceInstance serviceInstance = listInstances.get(0);
		// getting service based on loadfactor through LoadBalancerClient
		ServiceInstance serviceInstance = client.choose("billing-service");
		URI uri = serviceInstance.getUri();
		String url = uri+"/billing/api/info";
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		String responseContent = response.getBody();
		
		return responseContent;
	}


}
