package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.PermissionSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPermissionSetRepository extends JpaRepository<PermissionSetEntity, Long> {

    Optional<PermissionSetEntity> findByIdAndOrganizationId(Long id, Long organizationId);
}
