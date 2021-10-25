package com.example.demo.config;

import javax.sql.DataSource;

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
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery(
                "SELECT username, password, enabled from users where username = ?")
            .authoritiesByUsernameQuery(
                "SELECT u.username, a.authority " +
                "FROM authorities a, users u " +
                "WHERE u.username = ? " +
                "AND u.username = a.username"
            )
        .passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		// used while testing with postman
		http.authorizeRequests().antMatchers("/*.html").permitAll()
		      .antMatchers("/api/v1/**","/actuator/**").authenticated().and().csrf().disable().httpBasic();
		
		// used in a browser environment
//		http.authorizeRequests().antMatchers("/*.html").permitAll()
//	      .antMatchers("/api/v1/**").authenticated().and().httpBasic();
//	
	}


	
	
	
}
