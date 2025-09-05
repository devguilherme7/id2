package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationResponse;

public interface OrganizationService {

    OrganizationResponse createOrganization(String ownerId, String organizationName);
}
