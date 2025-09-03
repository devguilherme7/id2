package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationRequest;
import org.prosallo.organization.data.OrganizationResponse;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrganizationService implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    @Transactional
    public OrganizationResponse createOrganization(OrganizationRequest request) {
        Organization organization = Organization.createNew(request.name());
        Organization savedOrganization = organizationRepository.save(organization);
        return new OrganizationResponse(savedOrganization.getId(), savedOrganization.getName());
    }
}
