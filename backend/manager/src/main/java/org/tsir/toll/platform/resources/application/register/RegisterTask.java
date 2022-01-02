package org.tsir.toll.platform.resources.application.register;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.tsir.common.modules.TaskRegistrable;
import org.tsir.common.services.RegisterService;

public class RegisterTask implements TaskRegistrable {

	private Logger logger = LoggerFactory.getLogger(RegisterTask.class);

	@Autowired
	private RegisterService service;

	@Autowired
	private Environment env;

	@Override
	public void register() {
		List<String> results = new ArrayList<>();
		results.addAll(service.registerModule(HomeModule.INSTANCE, "/platform-home-app/main.js"));
		List<String> profs = Arrays.asList(env.getActiveProfiles());
		if (profs.contains("dev")) {
			results.addAll(service.registerModule(ResourcesModule.INSTANCE, "/platform-resources-app/main.js",
					"http://localhost:4203"));
		} else {
			results.addAll(service.registerModule(ResourcesModule.INSTANCE, "/platform-resources-app/main.js"));
		}

		logger.info("Registration Module Platform Home : \n{}", results);

	}

}
