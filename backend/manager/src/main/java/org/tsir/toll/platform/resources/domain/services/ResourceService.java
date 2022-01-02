package org.tsir.toll.platform.resources.domain.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsir.toll.platform.resources.domain.entities.Resource;

public interface ResourceService {

	Logger log = LoggerFactory.getLogger(ResourceService.class);

	void createResource(Resource resource);
	
	void checkResource(Resource resource);

	void updateResource(Long id, Resource resource);

	Resource getResourceById(Long id);

	List<Resource> findResources(Map<String, String> mapFilter);

	void deleteResource(Long id);

	List<Resource> getApplications();

}
