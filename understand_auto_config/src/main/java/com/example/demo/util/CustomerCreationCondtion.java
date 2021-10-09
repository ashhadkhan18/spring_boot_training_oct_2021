package com.example.demo.util;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomerCreationCondtion implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		boolean result = context.getBeanFactory().containsBean("tv");
		
		return  result;
		
		
	}

}
