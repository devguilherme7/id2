package org.prosallo.organization.infrastructure.repository.impl;

import org.prosallo.organization.infrastructure.entity.OrganizationEntity;
import org.prosallo.organization.infrastructure.mapper.JpaOrganizationMapper;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.infrastructure.repository.JpaOrganizationRepository;
import org.prosallo.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultOrganizationRepository implements OrganizationRepository {

    private final JpaOrganizationRepository jpaRepository;
    private final JpaOrganizationMapper jpaMapper;

    public DefaultOrganizationRepository(JpaOrganizationRepository jpaRepository, JpaOrganizationMapper jpaMapper) {
        this.jpaRepository = jpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public Organization save(Organization organization) {
        OrganizationEntity entity = jpaMapper.toEntity(organization);
        OrganizationEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }
}
