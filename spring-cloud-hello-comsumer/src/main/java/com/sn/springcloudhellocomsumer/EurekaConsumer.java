package com.sn.springcloudhellocomsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@RibbonClient(name="eureka-provider",configuration=RibbonConfig.class)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumer.class, args);
	}

	//添加负载均衡
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
