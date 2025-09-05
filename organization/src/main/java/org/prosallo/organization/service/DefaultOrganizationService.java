package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationResponse;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.model.OrganizationMember;
import org.prosallo.organization.repository.OrganizationMemberRepository;
import org.prosallo.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrganizationService implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMemberRepository organizationMemberRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository,
            OrganizationMemberRepository organizationMemberRepository) {
        this.organizationRepository = organizationRepository;
        this.organizationMemberRepository = organizationMemberRepository;
    }

    @Override
    @Transactional
    public OrganizationResponse createOrganization(String ownerId, String organizationName) {
        var organization = Organization.create(organizationName);
        organization = organizationRepository.save(organization);

        var owner = OrganizationMember.create(organization, ownerId);
        organizationMemberRepository.save(owner);

        return new OrganizationResponse(organization.getId(), organization.getName());
    }
}
