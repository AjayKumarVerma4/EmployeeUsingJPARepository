package com.hcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket employeeApi() {
	   return new Docket(DocumentationType.SWAGGER_2)
		    .groupName("Employee-API")
		    .useDefaultResponseMessages(false)
		    .apiInfo(apiInfo())
		    .select().apis(RequestHandlerSelectors.basePackage("com.hcl.controller")).paths(PathSelectors.any())
		    .build();
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Employee API")
				.description("Employee API reference for developer")
				.termsOfServiceUrl("http://fakeEmployee.com")
				.contact(new Contact("Employee API", "http://fakeEmployee.com", "fakeEmployee@gmail.com"))
				.license("Employee licence")
				.licenseUrl("http://fakeEmployee.com")
				.version("1.0.0")
				.build();
		
	}

}
