package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumingRestApplication { 

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplatesTest(RestTemplateBuilder builders) {
		return builders.build();
	}
//
	@Bean
	public CommandLineRunner run(RestTemplate restTemplatedd) throws Exception {
		return args -> {
//			Quote quote = restTemplate.getForObject(
//					"https://quoters.apps.pcfone.io/api/random", Quote.class);
			
			testJson quote = restTemplatedd.getForObject(
					"https://jsonplaceholder.typicode.com/posts/1", testJson.class);
			
			log.info(quote.toString());
		};
	}

}
