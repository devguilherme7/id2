package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationResponse;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.model.OrganizationMember;
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
    public OrganizationResponse createOrganization(String ownerId, String organizationName) {
        Organization organization = Organization.create(organizationName);

        OrganizationMember owner = OrganizationMember.create(ownerId);
        organization.addMember(owner);

        organization = organizationRepository.save(organization);
        return new OrganizationResponse(organization.getId(), organization.getName());
    }
}
