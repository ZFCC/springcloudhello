package com.sn.springcloudhelloeureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceA {

	public static void main(String[] args) {

		new SpringApplicationBuilder(EurekaServiceA.class).profiles("peerA").run(args);
	}
}
