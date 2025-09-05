package org.prosallo.organization.service;

import jakarta.persistence.EntityNotFoundException;
import org.prosallo.organization.model.OrganizationMember;
import org.prosallo.organization.model.OrganizationMemberPermissionSetAssignment;
import org.prosallo.organization.model.PermissionSet;
import org.prosallo.organization.repository.OrganizationMemberPermissionSetAssignmentRepository;
import org.prosallo.organization.repository.OrganizationMemberRepository;
import org.prosallo.organization.repository.OrganizationMemberService;
import org.prosallo.organization.repository.PermissionSetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultOrganizationMemberService implements OrganizationMemberService {

    private final OrganizationMemberRepository organizationMemberRepository;
    private final PermissionSetRepository permissionSetRepository;
    private final OrganizationMemberPermissionSetAssignmentRepository assignmentRepository;

    public DefaultOrganizationMemberService(OrganizationMemberRepository organizationMemberRepository,
            PermissionSetRepository permissionSetRepository,
            OrganizationMemberPermissionSetAssignmentRepository assignmentRepository) {
        this.organizationMemberRepository = organizationMemberRepository;
        this.permissionSetRepository = permissionSetRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    @Transactional
    public void assignPermissionSet(Long organizationId, Long memberId, Long permissionSetId) {
        OrganizationMember member = organizationMemberRepository.findByIdAndOrganizationId(memberId, organizationId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        PermissionSet permissionSet = permissionSetRepository
                .findByIdAndOrganizationId(permissionSetId, organizationId)
                .orElseThrow(() -> new EntityNotFoundException("Permission set not found"));

        OrganizationMemberPermissionSetAssignment assignment =
                OrganizationMemberPermissionSetAssignment.create(member, permissionSet);

        assignmentRepository.save(assignment);
    }
}
