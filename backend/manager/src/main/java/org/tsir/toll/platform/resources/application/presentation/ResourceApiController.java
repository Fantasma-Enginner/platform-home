package org.tsir.toll.platform.resources.application.presentation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsir.common.api.RequestHandler;
import org.tsir.common.services.resources.dto.ResourceDTO;
import org.tsir.toll.platform.resources.application.MappingFactory;
import org.tsir.toll.platform.resources.application.register.ResourcesModule;
import org.tsir.toll.platform.resources.domain.dto.ApplicationDTO;
import org.tsir.toll.platform.resources.domain.dto.AttributeDTO;
import org.tsir.toll.platform.resources.domain.dto.DOMElementDTO;
import org.tsir.toll.platform.resources.domain.dto.MappingDTO;
import org.tsir.toll.platform.resources.domain.dto.RouteDTO;
import org.tsir.toll.platform.resources.domain.dto.RouterDTO;
import org.tsir.toll.platform.resources.domain.entities.Resource;
import org.tsir.toll.platform.resources.domain.services.ResourceService;
import org.tsir.toll.platform.resources.domain.values.ApplicationType;
import org.tsir.toll.platform.resources.domain.values.RouteType;
import org.tsir.toll.platform.resources.infrastructure.api.ResourcesApi;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping({ "/api/v1" })
public class ResourceApiController extends RequestHandler implements ResourcesApi {

	@Autowired
	private MappingFactory mapper;

	@Autowired
	private ResourceService resourceService;

	@PostConstruct
	private void setResourceMapping() {
		Optional<ObjectMapper> objectMapper = getObjectMapper();
		if (objectMapper.isPresent()) {
			objectMapper.get().setSerializationInclusion(Include.NON_NULL);
		}
		mapper.loadResourceMapping();
	}

	@Override
	@PreAuthorize("hasAuthority('" + ResourcesModule.DELETE_RESOURCE_AUTHORITY + "')")
	public ResponseEntity<Void> deleteResource(Long id) {
		resourceService.deleteResource(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
//	@PreAuthorize("isAuthenticated() or hasAuthority('" + ResourcesModule.FIND_RESOURCES_AUTHORITY + "')")
	public ResponseEntity<List<ResourceDTO>> findResources(@Valid Map<String, String> filter) {
		List<Resource> results = resourceService.findResources(filter);
		List<ResourceDTO> body = results.stream().map(mapper::resourceToModel).collect(Collectors.toList());
		return ResponseEntity.ok(body);
	}

	@Override
	@PreAuthorize("hasAuthority('" + ResourcesModule.GET_RESOURCE_AUTHORITY + "')")
	public ResponseEntity<ResourceDTO> getResource(Long id) {
		return new ResponseEntity<>(mapper.resourceToModel(resourceService.getResourceById(id)), HttpStatus.OK);
	}

	@Override
	@PreAuthorize("hasAuthority('" + ResourcesModule.REGISTER_RESOURCE_AUTHORITY + "')")
	public ResponseEntity<Void> registerResource(@Valid ResourceDTO body) {
		resourceService.createResource(mapper.resourceToDomain(body));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	@PreAuthorize("hasAuthority('" + ResourcesModule.UPDATE_RESOURCE_AUTHORITY + "')")
	public ResponseEntity<Void> updateResource(Long id, @Valid ResourceDTO body) {
		resourceService.updateResource(id, mapper.resourceToDomain(body));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Void> checkResource(@RequestBody @Valid ResourceDTO body) {
		resourceService.checkResource(mapper.resourceToDomain(body));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<MappingDTO> getMapping() {
		List<Resource> applications = resourceService.getApplications();

		MappingDTO mapping = new MappingDTO();
		Map<String, String> imports = applications.stream()
				.collect(Collectors.toMap(Resource::getLabel, Resource::getLocation));
		mapping.setImports(imports);
		return ResponseEntity.ok(mapping);
	}

	@Override
	public ResponseEntity<RouterDTO> getLayout() {
		String attributeClass = "class";
		RouterDTO router = new RouterDTO();
		DOMElementDTO navTopnav = new DOMElementDTO().type("nav")
				.addAttrsItem(new AttributeDTO().name(attributeClass).value("topnav"))
				.addRoutesItem(new ApplicationDTO().name("Home").type(ApplicationType.APPLICATION));

		DOMElementDTO main = new DOMElementDTO().type("div")
				.addAttrsItem(new AttributeDTO().name(attributeClass).value("row justify-content-end"));

		DOMElementDTO divMainContent = new DOMElementDTO().type("div")
				.addAttrsItem(new AttributeDTO().name(attributeClass).value("col-md-12 col-lg-10"));

		List<Resource> applications = resourceService.getApplications();

		applications.stream().filter(this::isFrontRegistered)
				.forEach(r -> divMainContent.addRoutesItem(buildRoute(r.getPath(), r.getLabel())));

		main.addRoutesItem(divMainContent);
		router.addRoutesItem(navTopnav).addRoutesItem(main);
		return ResponseEntity.ok(router);
	}

	private boolean isFrontRegistered(Resource r) {
		return r.getCode() != 0 && r.getPath() != null && !r.getPath().trim().isEmpty();
	}

	private RouteDTO buildRoute(String path, String application) {
		return new RouteDTO().path(path).type(RouteType.ROUTE)
				.addRoutesItem(new ApplicationDTO().name(application).type(ApplicationType.APPLICATION));
	}

}
