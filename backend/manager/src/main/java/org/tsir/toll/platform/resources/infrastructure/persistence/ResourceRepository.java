package org.tsir.toll.platform.resources.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.tsir.toll.platform.resources.domain.entities.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>, QuerydslPredicateExecutor<Resource> {

}
