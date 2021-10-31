package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flight;

@Service
public class FlightService {

	@Autowired
	@Qualifier("topic_6e")
	private MessageChannel channel;
	
	
	@Autowired
	@Qualifier("topic_ai")
	private MessageChannel channel2;
	
	public boolean send(Flight flight) {
		
		
		
		
		return channel.send(MessageBuilder.withPayload(flight).build());
		
		
	}
}
