package com.sn.springcloudhelloprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProviderA {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaProviderA.class, args);

		new SpringApplicationBuilder(EurekaProviderA.class).properties("server.port="+8080).run(args);
	}
}
