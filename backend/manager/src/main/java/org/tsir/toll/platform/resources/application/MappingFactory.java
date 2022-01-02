package org.tsir.toll.platform.resources.application;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsir.common.services.resources.dto.ResourceDTO;
import org.tsir.common.services.resources.dto.ResourceType;
import org.tsir.common.services.resources.dto.StateActive;
import org.tsir.toll.platform.resources.domain.entities.Resource;

@Service
public class MappingFactory {

	@Autowired
	private ModelMapper modelMapper;

	public ResourceDTO resourceToModel(Resource entity) {
		return modelMapper.map(entity, ResourceDTO.class);
	}

	public Resource resourceToDomain(ResourceDTO model) {
		return modelMapper.map(model, Resource.class);
	}

	public void loadResourceMapping() {
		modelMapper.addConverter(this::longToResource, Long.class, Resource.class);
		modelMapper.addConverter(this::resourceToLong, Resource.class, Long.class);

		modelMapper.addConverter(this::getStateCode, StateActive.class, Integer.class);
		modelMapper.addConverter(this::getStateEnum, Integer.class, StateActive.class);

		modelMapper.addConverter(this::getTypeCode, ResourceType.class, Integer.class);
		modelMapper.addConverter(this::getTypeEnum, Integer.class, ResourceType.class);
	}

	protected Resource longToResource(MappingContext<Long, Resource> ctx) {
		if (ctx.getSource() != null) {
			Resource resource = new Resource();
			resource.setResourceId(ctx.getSource());
			return resource;
		}
		return null;
	}

	protected Long resourceToLong(MappingContext<Resource, Long> ctx) {
		return Objects.nonNull(ctx.getSource()) ? ctx.getSource().getResourceId() : null;
	}

	private StateActive getStateEnum(MappingContext<Integer, StateActive> ctx) {
		return Objects.nonNull(ctx.getSource()) ? StateActive.values()[ctx.getSource()] : null;
	}

	private Integer getStateCode(MappingContext<StateActive, Integer> ctx) {
		return Objects.nonNull(ctx.getSource()) ? ctx.getSource().ordinal() : null;
	}

	private ResourceType getTypeEnum(MappingContext<Integer, ResourceType> ctx) {
		return Objects.nonNull(ctx.getSource()) ? ResourceType.values()[ctx.getSource()] : null;
	}

	private Integer getTypeCode(MappingContext<ResourceType, Integer> ctx) {
		return Objects.nonNull(ctx.getSource()) ? ctx.getSource().ordinal() : null;
	}
}
