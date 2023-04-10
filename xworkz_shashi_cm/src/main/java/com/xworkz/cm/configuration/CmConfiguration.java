package com.xworkz.cm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.cm")
public class CmConfiguration {
	
	public CmConfiguration() {
		System.out.println(this.getClass().getSimpleName());
	}
	
	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Running viewResolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}
	
	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
		System.out.println("creating localEntityManagerFactoryBean");
		return new LocalEntityManagerFactoryBean();
	}
	
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
		
	}

}
