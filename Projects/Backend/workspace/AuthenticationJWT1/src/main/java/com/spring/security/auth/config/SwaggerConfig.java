package com.spring.security.auth.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
		info = @Info(
				title = "Jwt Practice 1",
				description = "I want to clear Innovator coding challenge",
				version = "1.0.0",
				contact = @Contact(
						name = "Dhananjay Jain",
						email = "jndhananjay@gmail.com"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Dj work",
				url = "www.dj.com"
				)
		)

@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
		)
public class SwaggerConfig {

}
