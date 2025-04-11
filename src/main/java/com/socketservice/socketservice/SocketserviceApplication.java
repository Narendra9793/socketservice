package com.socketservice.socketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SocketserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketserviceApplication.class, args);
	}

}
