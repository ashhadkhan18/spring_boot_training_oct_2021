package org.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("india").password(encoder.encode("india")).roles("ADMIN")
		            .and().withUser("nepal").password(encoder.encode("nepal")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		// used while testing with postman
		http.authorizeRequests().antMatchers("/*.html").permitAll()
		      .antMatchers("/api/v1/**").authenticated().and().csrf().disable().httpBasic();
		
		// used in a browser environment
//		http.authorizeRequests().antMatchers("/*.html").permitAll()
//	      .antMatchers("/api/v1/**").authenticated().and().httpBasic();
//	
	}


	
	
	
}
