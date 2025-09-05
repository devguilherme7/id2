package org.prosallo.organization.service;

import org.prosallo.organization.data.OrganizationResponse;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.model.OrganizationMember;
import org.prosallo.organization.model.OrganizationMemberRoleAssignment;
import org.prosallo.organization.model.Role;
import org.prosallo.organization.repository.OrganizationMemberRepository;
import org.prosallo.organization.repository.OrganizationMemberRoleAssignmentRepository;
import org.prosallo.organization.repository.OrganizationRepository;
import org.prosallo.organization.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrganizationService implements OrganizationService {

    private static final String SUPER_ADMIN_ROLE_NAME = "SUPER_ADMIN";

    private final OrganizationRepository organizationRepository;
    private final RoleRepository roleRepository;
    private final OrganizationMemberRepository organizationMemberRepository;
    private final OrganizationMemberRoleAssignmentRepository organizationMemberRoleAssignmentRepository;

    public DefaultOrganizationService(OrganizationRepository organizationRepository,
            RoleRepository roleRepository,
            OrganizationMemberRepository organizationMemberRepository,
            OrganizationMemberRoleAssignmentRepository organizationMemberRoleAssignmentRepository) {
        this.organizationRepository = organizationRepository;
        this.roleRepository = roleRepository;
        this.organizationMemberRepository = organizationMemberRepository;
        this.organizationMemberRoleAssignmentRepository = organizationMemberRoleAssignmentRepository;
    }

    @Override
    @Transactional
    public OrganizationResponse createOrganization(String ownerId, String organizationName) {
        Organization organization = Organization.create(organizationName);
        organization = organizationRepository.save(organization);

        Role ownerRole = Role.create(organization, SUPER_ADMIN_ROLE_NAME);
        ownerRole = roleRepository.save(ownerRole);

        OrganizationMember owner = OrganizationMember.create(organization, ownerId);
        owner.assignRole(ownerRole);
        owner = organizationMemberRepository.save(owner);

        OrganizationMemberRoleAssignment assignment = OrganizationMemberRoleAssignment.create(owner, ownerRole);
        organizationMemberRoleAssignmentRepository.save(assignment);

        return new OrganizationResponse(organization.getId(), organization.getName());
    }
}
