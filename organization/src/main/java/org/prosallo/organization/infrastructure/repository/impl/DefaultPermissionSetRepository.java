package org.prosallo.organization.infrastructure.repository.impl;

import org.prosallo.organization.infrastructure.entity.PermissionSetEntity;
import org.prosallo.organization.infrastructure.mapper.JpaPermissionSetMapper;
import org.prosallo.organization.infrastructure.repository.JpaPermissionSetRepository;
import org.prosallo.organization.model.PermissionSet;
import org.prosallo.organization.repository.PermissionSetRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultPermissionSetRepository implements PermissionSetRepository {

    private final JpaPermissionSetRepository jpaRepository;
    private final JpaPermissionSetMapper jpaMapper;

    public DefaultPermissionSetRepository(JpaPermissionSetRepository jpaRepository, JpaPermissionSetMapper jpaMapper) {
        this.jpaRepository = jpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public PermissionSet save(PermissionSet permissionSet) {
        PermissionSetEntity entity = jpaMapper.toEntity(permissionSet);
        PermissionSetEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<PermissionSet> findByIdAndOrganizationId(Long id, Long organizationId) {
        return jpaRepository.findByIdAndOrganizationId(id, organizationId).map(jpaMapper::toDomain);
    }
}
