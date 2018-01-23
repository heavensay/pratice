package com.pratice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerProvider1Application.class, args);
	}
}
