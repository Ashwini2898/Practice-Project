package com.cg.registration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@SpringBootApplication(scanBasePackages="com.cg.registration")
@EntityScan(basePackages="com.cg.registration.entity")
@EnableJpaRepositories(basePackages="com.cg.registration.dao")
public class RegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}
	@Bean
	public Docket openApiRegistrationStore() 
	{
		return new Docket(DocumentationType.OAS_30)
				.groupName("open-api-registration-store")
				.select()
				.paths(registrationPaths())
				.build();
	}
	private Predicate<String> registrationPaths()
	{
		return regex(".*/api/registration/.*");
	}
}
