package com.example.demo.actuator.utils;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@Component
public class CustomInfoEndpoint implements InfoContributor {

	
	@Autowired
	ConfigurableWebApplicationContext ctx;
	
	@Override
	public void contribute(Builder builder) {
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("beanCount",ctx.getBeanDefinitionCount());
		map.put("startup", ctx.getStartupDate());
		
		
		builder.withDetails(map);
	}

}
