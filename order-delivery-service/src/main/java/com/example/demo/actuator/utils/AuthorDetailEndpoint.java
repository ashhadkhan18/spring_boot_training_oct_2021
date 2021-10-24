package com.example.demo.actuator.utils;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@Component
@WebEndpoint(id = "authors")
public class AuthorDetailEndpoint {

	
	String author = "Srivatsan";
	
	
	
	@ReadOperation
	public String getAuthor() {
		
		return this.author;
	}
	
	
	@WriteOperation
	public String getUpdatedAuthor(@Selector String revisedName) {
		
		StringBuffer buffer = new StringBuffer(author);
		
		 return buffer.append(revisedName).toString();
		 
	}
	
}
