package com.anything.swagger.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public Docket swaggerApi() {

		return new Docket(DocumentationType.SWAGGER_2)
				.consumes(getConsumeContentTypes())
				.produces(getProduceContentTypes())
				.apiInfo(swaggerInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.anything"))
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false);
	}

	private ApiInfo swaggerInfo() {

		return new ApiInfoBuilder()
				.title("Anything API")
				.description("Anything API Docs")
				.version("1.0.0")
				.build();
	}

	private Set<String> getConsumeContentTypes() {

		Set<String> consumes = new HashSet<>();
		consumes.add("application/json; charset=UTF-8");
		consumes.add("application/x-www-form-urlencoded");
		return consumes;
	}

	private Set<String> getProduceContentTypes() {

		Set<String> produces = new HashSet<>();
		produces.add("application/json; charset=UTF-8");
		return produces;
	}
}
