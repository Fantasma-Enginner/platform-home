package org.tsir.toll.platform.resources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.tsir.common.api.exceptions.handler.ApiRestExceptionHandler;
import org.tsir.common.services.RegisterService;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = { PlatformManagerApplication.class, ApiRestExceptionHandler.class,
		RegisterService.class })
@EnableJpaRepositories
public class PlatformManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformManagerApplication.class, args);
	}

}
