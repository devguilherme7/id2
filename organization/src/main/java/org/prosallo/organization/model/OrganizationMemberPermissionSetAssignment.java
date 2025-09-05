package org.prosallo.organization.model;

import org.prosallo.core.domain.AggregateRoot;

public final class OrganizationMemberPermissionSetAssignment extends AggregateRoot {

    private final OrganizationMember member;
    private final PermissionSet permissionSet;

    public OrganizationMemberPermissionSetAssignment(OrganizationMember member, PermissionSet permissionSet) {
        this.member = member;
        this.permissionSet = permissionSet;
    }

    public static OrganizationMemberPermissionSetAssignment create(OrganizationMember member, PermissionSet permissionSet) {
        return new OrganizationMemberPermissionSetAssignment(member, permissionSet);
    }

    public OrganizationMember getMember() {
        return member;
    }

    public PermissionSet getPermissionSet() {
        return permissionSet;
    }
}