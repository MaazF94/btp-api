package com.btp.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration corConfig = new CorsConfiguration();
			corConfig.setAllowedHeaders(Arrays.asList("*"));
			corConfig.setAllowedMethods(Arrays.asList("GET", "OPTIONS", "POST", "DELETE"));
			corConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
			corConfig.setMaxAge(1800L);
			source.registerCorsConfiguration("/**", corConfig);
			return source;
	}
}