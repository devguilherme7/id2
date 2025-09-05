package org.prosallo.organization.infrastructure.repository;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaOrganizationMemberRepository extends JpaRepository<OrganizationMemberEntity, Long> {

    Optional<OrganizationMemberEntity> findByIdAndOrganizationId(Long id, Long organizationId);
}
