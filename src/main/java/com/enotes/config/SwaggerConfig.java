package com.enotes.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		OpenAPI openApi = new OpenAPI();

		Info info = new Info();
		info.setTitle("Enotes API");
		info.setDescription("Enotes Api");
		info.setVersion("1.0.0");
		info.setContact(
				new Contact().email("tempmail@gmail.com").name("Rudo").url("https://example.com"));
		info.setLicense(new License().name("Enotes 1.0").url("https://example.com"));

		List<Server> serverList = List.of(new Server().description("Dev").url("http://localhost:8080"),
				new Server().description("Test").url("http://localhost:8081"),
				new Server().description("Prod").url("http://localhost:8083"));

		// bearer sdbhkj.sdfdvs.sdfvsdc
		SecurityScheme securityScheme = new SecurityScheme().name("Authorization").scheme("bearer").type(Type.HTTP)
				.bearerFormat("JWT").in(In.HEADER);

		Components component = new Components().addSecuritySchemes("Token", securityScheme);
		openApi.setServers(serverList);
		openApi.setInfo(info);
		openApi.setComponents(component);
		openApi.setSecurity(List.of(new SecurityRequirement().addList("Token")));
		return openApi;
	}

}
