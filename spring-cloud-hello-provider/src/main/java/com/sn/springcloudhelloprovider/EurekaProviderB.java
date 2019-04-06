package com.sn.springcloudhelloprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderB {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaProviderB.class, args);

		new SpringApplicationBuilder(EurekaProviderB.class).properties("server.port="+8081).run(args);
	}
}
