package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;

import com.example.demo.model.RestaurantInfo;
import com.example.demo.model.Review;

@SpringBootApplication
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class IocExampleApplication {

	
	
	public static void main(String[] args) {
		// Capturing the Reference to the Ioc Container here => represented by ctx
		
	ConfigurableApplicationContext	ctx=
			  SpringApplication.run(IocExampleApplication.class, args);
	
	
	System.out.println(ctx.getClass().getName());
	
	
	// Accessing by passing Class Reference 
	
	   Review objRef = ctx.getBean("reviewBean",Review.class);
	   
	   
	   
      
	   
	   
	 // accessing by passing class reference and id
	   
	   Review objRef2 =ctx.getBean("reviewBean",Review.class);
	   
	  
        Review sangeetha = ctx.getBean("foodReview",Review.class);
	   
	   System.out.println(sangeetha);
	  
	   
	   // accesing by passing just id
	   
	   Review objRef3 =(Review)ctx.getBean("reviewBean");
			   
	   
	   System.out.println(objRef);
	   
	   System.out.println(objRef2);
	   
	   System.out.println(objRef3);
	   
	   System.out.println(ctx.getBean("ambience",Review.class));
	   
	   
	   
	   // Look at Server console and observe the message from Constructor is printed only once and not thrice
	   	   
	ctx.close();
	}

}
