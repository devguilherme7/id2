package org.prosallo.organization.repository;

import org.prosallo.organization.model.PermissionSet;

import java.util.Optional;

public interface PermissionSetRepository {

    PermissionSet save(PermissionSet permissionSet);

    Optional<PermissionSet> findByIdAndOrganizationId(Long id, Long organizationId);
}
