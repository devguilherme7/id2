package org.prosallo.organization.infrastructure.repository.impl;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberPermissionSetAssignmentEntity;
import org.prosallo.organization.infrastructure.mapper.JpaOrganizationMemberPermissionSetAssignmentMapper;
import org.prosallo.organization.infrastructure.repository.JpaOrganizationMemberPermissionSetAssignmentRepository;
import org.prosallo.organization.model.OrganizationMemberPermissionSetAssignment;
import org.prosallo.organization.repository.OrganizationMemberPermissionSetAssignmentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultOrganizationMemberPermissionSetAssignmentRepository implements OrganizationMemberPermissionSetAssignmentRepository {

    private final JpaOrganizationMemberPermissionSetAssignmentRepository jpaRepository;
    private final JpaOrganizationMemberPermissionSetAssignmentMapper jpaMapper;

    public DefaultOrganizationMemberPermissionSetAssignmentRepository(
            JpaOrganizationMemberPermissionSetAssignmentRepository jpaRepository,
            JpaOrganizationMemberPermissionSetAssignmentMapper jpaMapper) {
        this.jpaRepository = jpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public OrganizationMemberPermissionSetAssignment save(OrganizationMemberPermissionSetAssignment assignment) {
        OrganizationMemberPermissionSetAssignmentEntity entity = jpaMapper.toEntity(assignment);
        OrganizationMemberPermissionSetAssignmentEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }
}