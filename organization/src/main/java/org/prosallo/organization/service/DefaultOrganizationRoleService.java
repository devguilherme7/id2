package org.prosallo.organization.service;

import jakarta.persistence.EntityNotFoundException;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.model.Role;
import org.prosallo.organization.repository.OrganizationRepository;
import org.prosallo.organization.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrganizationRoleService implements OrganizationRoleService {

    private final OrganizationRepository organizationRepository;
    private final RoleRepository roleRepository;

    public DefaultOrganizationRoleService(OrganizationRepository organizationRepository,
            RoleRepository roleRepository) {
        this.organizationRepository = organizationRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public Role createRole(Long organizationId, String roleName) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        Role role = Role.create(organization, roleName);
        return roleRepository.save(role);
    }
}
