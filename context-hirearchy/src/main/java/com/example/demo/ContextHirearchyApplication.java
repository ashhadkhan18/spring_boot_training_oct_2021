package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.child.context.ChildContextConfiguration;
import com.example.demo.model.Customer;

@SpringBootApplication
public class ContextHirearchyApplication {

	public static void main(String[] args) {
	
	
	ConfigurableApplicationContext	ctx =new SpringApplicationBuilder(ContextHirearchyApplication.class)
			.child(ChildContextConfiguration.class)
			.run(args);
	
	System.out.println(ctx.getBean("parent").toString());
	System.out.println(ctx.getBean("child").toString());
	
	Customer master = (Customer)ctx.getBean("master");
	Customer detail =(Customer)ctx.getBean("detail");

	System.out.println(master.toString() +"Is Master Singleton:="+ ctx.isSingleton("master"));
	System.out.println(detail.toString() +"Is details singleton:="+ctx.isSingleton("detail"));
	
	
	ctx.close();
	}
	

	@Bean(name = "parent")
	public String parent() {
		return "I am the Parent";
	}
	
	@Bean
	public Customer master() {
		System.out.println("master called ============");
		return new Customer(101, "Parent Shiv", "shiv@abc.com");
		
	}

}
