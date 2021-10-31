package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.example.demo.utils.MySource;

@SpringBootApplication
@EnableBinding(MySource.class)
public class FlightServiceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceProducerApplication.class, args);
	}

}
