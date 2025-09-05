package org.prosallo.organization.infrastructure.repository.impl;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberRoleAssignmentEntity;
import org.prosallo.organization.infrastructure.mapper.JpaOrganizationMemberRoleAssignmentMapper;
import org.prosallo.organization.infrastructure.repository.JpaOrganizationMemberRoleAssignmentRepository;
import org.prosallo.organization.model.OrganizationMemberRoleAssignment;
import org.prosallo.organization.repository.OrganizationMemberRoleAssignmentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultOrganizationMemberRoleAssignmentRepository implements OrganizationMemberRoleAssignmentRepository {

    private final JpaOrganizationMemberRoleAssignmentRepository jpaRepository;
    private final JpaOrganizationMemberRoleAssignmentMapper jpaMapper;

    public DefaultOrganizationMemberRoleAssignmentRepository(
            JpaOrganizationMemberRoleAssignmentRepository jpaRepository,
            JpaOrganizationMemberRoleAssignmentMapper jpaMapper) {
        this.jpaRepository = jpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public OrganizationMemberRoleAssignment save(OrganizationMemberRoleAssignment assignment) {
        OrganizationMemberRoleAssignmentEntity entity = jpaMapper.toEntity(assignment);
        OrganizationMemberRoleAssignmentEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }
}
