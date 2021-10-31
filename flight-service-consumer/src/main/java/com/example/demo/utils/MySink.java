package com.example.demo.utils;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {

	@Input("topic_6e")
	SubscribableChannel subscriber();
	
}
