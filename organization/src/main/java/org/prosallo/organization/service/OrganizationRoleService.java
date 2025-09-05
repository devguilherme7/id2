package org.prosallo.organization.service;

import org.prosallo.organization.model.Role;

public interface OrganizationRoleService {

    Role createRole(Long organizationId, String roleName);
}
