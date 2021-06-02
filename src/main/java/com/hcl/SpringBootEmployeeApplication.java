package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootEmployeeApplication extends SpringBootServletInitializer {
	
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
                  return application.sources(SpringBootEmployeeApplication.class);
        }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeApplication.class, args);
	}

}
