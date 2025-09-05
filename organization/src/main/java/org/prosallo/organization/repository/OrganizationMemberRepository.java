package org.prosallo.organization.repository;

import org.prosallo.organization.model.OrganizationMember;

import java.util.Optional;

public interface OrganizationMemberRepository {

    OrganizationMember save(OrganizationMember organizationMember);

    Optional<OrganizationMember> findByIdAndOrganizationId(Long id, Long organizationId);
}
