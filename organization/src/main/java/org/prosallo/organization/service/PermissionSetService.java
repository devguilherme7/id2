package org.prosallo.organization.service;

import org.prosallo.organization.model.PermissionSet;

public interface PermissionSetService {

    PermissionSet createPermissionSet(Long organizationId, String permissionSetName);
}