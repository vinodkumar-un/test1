package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj04BillingServiceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj04BillingServiceProducerApplication.class, args);
	}

}
