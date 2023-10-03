package com.quiz.Servicereigstry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceReigstryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceReigstryApplication.class, args);
	}

}
