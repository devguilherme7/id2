package org.prosallo.organization.repository;

import org.prosallo.organization.model.Organization;

import java.util.Optional;

public interface OrganizationRepository {

    Organization save(Organization organization);

    Optional<Organization> findById(Long id);
}
