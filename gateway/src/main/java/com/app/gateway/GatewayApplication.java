package com.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GatewayApplication {

	// El siguiente codigo es util cuando necesitamos resolber nombre de dominio como
	// http://productr-service. Esto hace que dicha solicitud sea delegada a un servidor
	// de descubrimiento de servicio como Nexflix Eureka.
	/*
	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClient(){
		return WebClient.builder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
