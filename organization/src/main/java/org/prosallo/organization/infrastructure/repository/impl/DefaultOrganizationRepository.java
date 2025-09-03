package org.prosallo.organization.infrastructure.repository.impl;

import lombok.RequiredArgsConstructor;
import org.prosallo.organization.infrastructure.entity.OrganizationEntity;
import org.prosallo.organization.infrastructure.mapper.JpaOrganizationMapper;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.infrastructure.repository.JpaOrganizationRepository;
import org.prosallo.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DefaultOrganizationRepository implements OrganizationRepository {

    private final JpaOrganizationRepository jpaRepository;
    private final JpaOrganizationMapper jpaMapper;

    @Override
    public Organization save(Organization organization) {
        OrganizationEntity entity = jpaMapper.toEntity(organization);
        OrganizationEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }
}
