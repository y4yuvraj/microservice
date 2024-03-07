package com.yuv.microservicesbasics.eurekadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesBasicsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBasicsEurekaServerApplication.class, args);
	}

}
