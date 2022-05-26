package com.ssn.configclientseller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientSellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientSellerApplication.class, args);
	}

}
