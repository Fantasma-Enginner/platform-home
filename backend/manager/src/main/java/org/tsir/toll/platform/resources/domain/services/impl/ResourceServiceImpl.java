package org.tsir.toll.platform.resources.domain.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.stereotype.Service;
import org.tsir.common.api.exceptions.ConflictException;
import org.tsir.common.api.exceptions.DataTypeCriteriaException;
import org.tsir.common.api.exceptions.NotFoundException;
import org.tsir.common.api.exceptions.NotSupportCriteriaException;
import org.tsir.common.api.exceptions.ServerProcessException;
import org.tsir.common.services.resources.dto.ResourceType;
import org.tsir.common.services.resources.dto.StateActive;
import org.tsir.toll.platform.resources.domain.entities.QResource;
import org.tsir.toll.platform.resources.domain.entities.Resource;
import org.tsir.toll.platform.resources.domain.services.ResourceService;
import org.tsir.toll.platform.resources.domain.values.ResourcesCriteria;
import org.tsir.toll.platform.resources.infrastructure.persistence.ResourceRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Service
public class ResourceServiceImpl implements ResourceService {

	private static final String RESOURCE_NAME = "Recurso";
	private static final String RESOURCE_KEY = "Identificador";

	@Autowired
	private ResourceRepository resourceDAO;

	@Override
	public void createResource(Resource resource) {
		if (resourceDAO.existsById(resource.getResourceId())) {
			throw new ConflictException(RESOURCE_NAME, RESOURCE_NAME, String.valueOf(resource.getResourceId()));
		}
		resourceDAO.save(resource);
	}

	@Override
	public void checkResource(Resource resource) {
		if (resourceDAO.existsById(resource.getResourceId())) {
			updateResource(resource.getResourceId(), resource);
		}
		resourceDAO.save(resource);
	}

	@Override
	public void updateResource(Long id, Resource resource) {
		Resource local = resourceDAO.findById(id)
				.orElseThrow(() -> new NotFoundException(RESOURCE_NAME, RESOURCE_KEY, String.valueOf(id)));
		try {
			BeanUtils.copyProperties(resource, local);
		} catch (BeansException e) {
			throw new ServerProcessException("Mo ha sido posible actualizar los datos del recurso", e);
		}
		resourceDAO.save(local);
	}

	@Override
	public Resource getResourceById(Long id) {
		return resourceDAO.findById(id)
				.orElseThrow(() -> new NotFoundException(RESOURCE_NAME, RESOURCE_KEY, id.toString()));
	}

	@Override
	public List<Resource> findResources(Map<String, String> mapFilter) {
		QResource qResource = QResource.resource;
		Sort sort = new QSort(qResource.resourceId.asc());
		if (ObjectUtils.isNotEmpty(mapFilter)) {
			BooleanBuilder builder = new BooleanBuilder();
			mapFilter.forEach((k, v) -> builder.and(this.getPredicate(qResource, k, v)));
			return IterableUtils.toList(resourceDAO.findAll(builder, sort));
		}
		return resourceDAO.findAll(sort);
	}

	private Predicate getPredicate(QResource q, String criteria, String value) {
		try {
			ResourcesCriteria rc = ResourcesCriteria.fromKey(criteria);
			switch (rc) {
			case ID_KEY:
				String[] array = value.replaceAll("\\s", "").split(",");
				Stream<Long> stream = Arrays.stream(array, 0, array.length).map(Long::valueOf);
				return q.resourceId.in(stream.collect(Collectors.toList()));
			case CODE_KEY:
				return q.code.eq(Integer.valueOf(value));
			case LABEL_KEY:
				return q.label.containsIgnoreCase(value);
			case STATE_KEY:
				StateActive state = StateActive.fromValue(value);
				return q.active.eq(state.ordinal());
			case PARENT_KEY:
				return q.parent.eq(Long.parseLong(value));
			case TYPE_KEY:
				ResourceType type = ResourceType.fromValue(value);
				return q.type.eq(type.ordinal());
			default:
				throw new NotSupportCriteriaException(RESOURCE_NAME, criteria);
			}
		} catch (NumberFormatException nfe) {
			throw new DataTypeCriteriaException(RESOURCE_NAME, criteria, "Numérico");
		}
	}

	@Override
	public void deleteResource(Long id) {
		Resource local = getResourceById(id);
		resourceDAO.delete(local);
		log.info("Se ha realizado la eliminaciòn del recurso {} con identificador {}", local.getLabel(), id);
	}

	@Override
	public List<Resource> getApplications() {
		QResource q = QResource.resource;
		Sort sort = new QSort(q.resourceId.asc());
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(q.type.eq(ResourceType.MODULO.ordinal())).and(q.location.isNotNull());
		return IterableUtils.toList(resourceDAO.findAll(builder, sort));
	}

}
