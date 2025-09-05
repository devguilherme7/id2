package org.prosallo.organization.infrastructure.repository.impl;

import org.prosallo.organization.infrastructure.entity.RoleEntity;
import org.prosallo.organization.infrastructure.mapper.JpaRoleMapper;
import org.prosallo.organization.infrastructure.repository.JpaRoleRepository;
import org.prosallo.organization.model.Role;
import org.prosallo.organization.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultRoleRepository implements RoleRepository {

    private final JpaRoleRepository jpaRepository;
    private final JpaRoleMapper jpaMapper;

    public DefaultRoleRepository(JpaRoleRepository jpaRepository, JpaRoleMapper jpaMapper) {
        this.jpaRepository = jpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public Role save(Role role) {
        RoleEntity entity = jpaMapper.toEntity(role);
        RoleEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }
}
