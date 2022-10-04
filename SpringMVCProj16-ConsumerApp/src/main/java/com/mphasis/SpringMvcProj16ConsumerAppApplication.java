package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringMvcProj16ConsumerAppApplication {
	
	@Bean(name = "template")
	public RestTemplate createTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProj16ConsumerAppApplication.class, args);
	}

}
