package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberPermissionSetAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrganizationMemberPermissionSetAssignmentRepository
        extends JpaRepository<OrganizationMemberPermissionSetAssignmentEntity, Long> {
}