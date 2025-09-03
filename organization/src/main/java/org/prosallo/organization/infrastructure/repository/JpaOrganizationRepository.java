package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrganizationRepository extends JpaRepository<OrganizationEntity, Long> {}
