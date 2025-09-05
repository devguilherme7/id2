package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationResponse;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.model.OrganizationMember;
import org.prosallo.organization.model.OrganizationMemberPermissionSetAssignment;
import org.prosallo.organization.model.PermissionSet;
import org.prosallo.organization.repository.OrganizationMemberRepository;
import org.prosallo.organization.repository.OrganizationMemberPermissionSetAssignmentRepository;
import org.prosallo.organization.repository.OrganizationRepository;
import org.prosallo.organization.repository.PermissionSetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrganizationService implements OrganizationService {

    private static final String SUPER_ADMIN_ROLE_NAME = "SUPER_ADMIN";

    private final OrganizationRepository organizationRepository;
    private final PermissionSetRepository permissionSetRepository;
    private final OrganizationMemberRepository organizationMemberRepository;
    private final OrganizationMemberPermissionSetAssignmentRepository organizationMemberPermissionSetAssignmentRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository,
            PermissionSetRepository permissionSetRepository,
            OrganizationMemberRepository organizationMemberRepository,
            OrganizationMemberPermissionSetAssignmentRepository organizationMemberPermissionSetAssignmentRepository) {
        this.organizationRepository = organizationRepository;
        this.permissionSetRepository = permissionSetRepository;
        this.organizationMemberRepository = organizationMemberRepository;
        this.organizationMemberPermissionSetAssignmentRepository = organizationMemberPermissionSetAssignmentRepository;
    }

    @Override
    @Transactional
    public OrganizationResponse createOrganization(String ownerId, String organizationName) {
        Organization organization = Organization.create(organizationName);
        organization = organizationRepository.save(organization);

        PermissionSet ownerPermissionSet = PermissionSet.create(organization, SUPER_ADMIN_ROLE_NAME);
        ownerPermissionSet = permissionSetRepository.save(ownerPermissionSet);

        OrganizationMember owner = OrganizationMember.create(organization, ownerId);
        owner = organizationMemberRepository.save(owner);

        OrganizationMemberPermissionSetAssignment assignment =
                OrganizationMemberPermissionSetAssignment.create(owner, ownerPermissionSet);
        organizationMemberPermissionSetAssignmentRepository.save(assignment);

        return new OrganizationResponse(organization.getId(), organization.getName());
    }
}
