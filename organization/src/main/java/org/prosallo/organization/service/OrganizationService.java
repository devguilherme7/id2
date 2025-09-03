package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationRequest;
import org.prosallo.organization.data.OrganizationResponse;

public interface OrganizationService {

    OrganizationResponse createOrganization(OrganizationRequest request);
}
