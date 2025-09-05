package org.prosallo.organization.repository;

public interface OrganizationMemberService {

    void assignPermissionSet(Long organizationId, Long memberId, Long permissionSetId);
}
