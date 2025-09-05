package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberRoleAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrganizationMemberRoleAssignmentRepository
        extends JpaRepository<OrganizationMemberRoleAssignmentEntity, Long> {
}
