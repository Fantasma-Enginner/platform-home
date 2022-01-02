package org.tsir.toll.platform.resources.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.tsir.common.modules.TaskRegistrable;
import org.tsir.common.services.RegisterService;
import org.tsir.common.utils.ObjectUtilsVP;
import org.tsir.toll.platform.resources.application.register.RegisterTask;

@Configuration
public class ApplicationConfig {

	public static final String API_VERSION = "1.0.0";
	public static final String IMPLEMENTATION_VERSION = "1.0.1";
	public static final String MODULE_DESCRIPTION = "Servicios para la gestión del sistema de peajes.";
	public static final String MODULE_NAME = "PlatformHome";

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return ObjectUtilsVP.getClient();
	}

	@Bean
	public RegisterService getRegisterService() {
		RegisterService registerService = new RegisterService();
		registerService.setHost("platform-manager");
		return registerService;
	}

	@Bean
	public TaskRegistrable getRegisterProductionTask() {
		return new RegisterTask();
	}

}
