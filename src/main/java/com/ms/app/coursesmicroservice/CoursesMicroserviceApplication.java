package com.ms.app.coursesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.ms.app.commonsstudents.models.entity", "com.ms.app.coursesmicroservice.models.entity" })
public class CoursesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesMicroserviceApplication.class, args);
	}

}
