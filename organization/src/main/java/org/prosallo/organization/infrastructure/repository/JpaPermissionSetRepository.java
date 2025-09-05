package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.PermissionSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPermissionSetRepository extends JpaRepository<PermissionSetEntity, Long> {}