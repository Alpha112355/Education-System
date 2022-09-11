//package com.cg.education_system.configure;
//
////import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////import com.cg.education_system.Service.StudentService;
//
//@EnableWebSecurity
//public class Security extends WebSecurityConfigurerAdapter{
////	
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth.inMemoryAuthentication()
//		.withUser("get")
//		.password("get")
//		.roles("USER");
//		
//		
////		auth.inMemoryAuthentication()
////		.withUser("mig")
////		.password("mig")
////		.roles("ADMIN");
//	}
//	
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//		
//	}
//	
////
////	
//	
//
//}
