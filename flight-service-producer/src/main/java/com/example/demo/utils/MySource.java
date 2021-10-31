package com.example.demo.utils;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

	@Output("topic_6e")
	MessageChannel details();
}
