package com.mskafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class MskafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MskafkaApplication.class, args);
	}
	


}
