package com.m3bi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi1() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("avk-api")
						.apiInfo(getApiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return Predicates.or(PathSelectors.regex("/user.*"), PathSelectors.regex("/hotel.*"));
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Hotel booking endpoints list")
					.description("Swagger UI for hotel booking")
					.license("AVK License")
					.licenseUrl("avk.kirankumar@gmail.com")
					.version("1.0").build();
	}
}