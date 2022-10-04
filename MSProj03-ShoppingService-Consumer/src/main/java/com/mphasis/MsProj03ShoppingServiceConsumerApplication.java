package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProj03ShoppingServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj03ShoppingServiceConsumerApplication.class, args);
	}

}
