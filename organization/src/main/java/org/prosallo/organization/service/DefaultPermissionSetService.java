package org.prosallo.organization.service;

import jakarta.persistence.EntityNotFoundException;
import org.prosallo.organization.model.Organization;
import org.prosallo.organization.model.PermissionSet;
import org.prosallo.organization.repository.OrganizationRepository;
import org.prosallo.organization.repository.PermissionSetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultPermissionSetService implements PermissionSetService {

    private final OrganizationRepository organizationRepository;
    private final PermissionSetRepository permissionSetRepository;

    public DefaultPermissionSetService(OrganizationRepository organizationRepository,
                                 PermissionSetRepository permissionSetRepository) {
        this.organizationRepository = organizationRepository;
        this.permissionSetRepository = permissionSetRepository;
    }

    @Override
    @Transactional
    public PermissionSet createPermissionSet(Long organizationId, String permissionSetName) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found"));

        PermissionSet permissionSet = PermissionSet.create(organization, permissionSetName);
        return permissionSetRepository.save(permissionSet);
    }
}