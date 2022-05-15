package com.anything.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.anything.interceptor.ServletInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	private final List<String> excludePath = new ArrayList<>();

	public MvcConfig() {

		excludePath.add("/css/**");
		excludePath.add("/fonts/**");
		excludePath.add("/plugin/**");
		excludePath.add("/scripts/**");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new ServletInterceptor())
		.excludePathPatterns(excludePath);
	}
}
