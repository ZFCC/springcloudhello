package com.sn.springcloudhelloeureka;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCloudHelloEurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringCloudHelloEurekaApplication.class).properties("server.port="+8888).run(args);
	}

	//添加负载均衡
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

/*	@Bean
	public IRule MyRule(){
//        return new WeightedResponseTimeRule();
//        return new ZoneAvoidanceRule();
		return new RandomRule();
	}*/
}
