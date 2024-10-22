package com.prat.apiintegrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiIntegrationServiceApplication.class, args);
	}

}
