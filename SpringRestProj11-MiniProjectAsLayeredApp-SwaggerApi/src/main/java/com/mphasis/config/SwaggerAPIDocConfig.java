package com.mphasis.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerAPIDocConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mphasis.rest"))
				//.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/actor/api.*"))
				//.paths(PathSelectors.ant("/actor/api/**"))
				.build()
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("shami", "http://www.mphasis.com/recruiter", "shami@mphasis.com");

		return new ApiInfo("Actor API Doc", "API Info Actor API", "5.7.RELEASE",
				"http://www.mphasis.com/license", contact, "GNU Public", "http://apache.org/license/gnu",
				Collections.emptyList());
	}

}
