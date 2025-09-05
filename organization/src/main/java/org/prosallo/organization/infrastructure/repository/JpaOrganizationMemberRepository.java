package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrganizationMemberRepository extends JpaRepository<OrganizationMemberEntity, Long> {}
