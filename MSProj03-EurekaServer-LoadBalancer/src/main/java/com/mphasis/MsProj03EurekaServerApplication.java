package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsProj03EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj03EurekaServerApplication.class, args);
	}

}