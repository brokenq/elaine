package com.brokenq.elaine.test.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brokenq.elaine.test.bean.UserBean;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public UserBean userBean(){
		return new UserBean();
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		UserBean user = context.getBean(UserBean.class);
		user.setUsername("Test");
		System.out.println(user.getUsername());
	}
}
