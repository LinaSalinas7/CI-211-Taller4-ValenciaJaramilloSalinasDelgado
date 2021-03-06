package com.edu.icesi.ci.taller4.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf().disable().authorizeRequests()
		.antMatchers("/trigerrs/**").access("hasRole('administrador')")
		.antMatchers("/trigertypes/**").access("hasRole('administrador')")
		.antMatchers("/persons/**").access("hasRole('administrador')")
		.antMatchers("/autotransitions/**").access("hasRole('operador')")
		.antMatchers("/userselects/**").access("hasRole('operador')")
		.antMatchers("/trigerrs/**").access("hasRole('operador')")
		.antMatchers("/api-rest/**").permitAll()
		.antMatchers("/h2/**").permitAll()
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.permitAll()
		.and()
			.logout()
			.invalidateHttpSession(true).clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")				
			.permitAll()
		.and()
		.exceptionHandling()
			.accessDeniedHandler(accessDeniedHandler);
		
		
//		httpSecurity.cors().and().authorizeRequests()
//		.antMatchers("/trigerrs/**").access("hasRole('administrador')")
//		.antMatchers("/trigertypes/**").access("hasRole('administrador')")
//		.antMatchers("/person/**").access("hasRole('administrador')")
//		.antMatchers("/autotransitions/**").access("hasRole('operador')")
//		.antMatchers("/userselects/**").access("hasRole('operador')")
//		.antMatchers("/trigerrs/**").access("hasRole('operador')")
//		.antMatchers("/api-rest/**").permitAll()
//		.antMatchers("/h2/**").permitAll()
//		.anyRequest().authenticated()
//		.and()
//			.formLogin()
//			.permitAll()
//		.and()
//			.logout()
//			.invalidateHttpSession(true).clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")				
//			.permitAll()
//		.and()
//		.exceptionHandling()
//			.accessDeniedHandler(accessDeniedHandler);
//		
		
	}
}