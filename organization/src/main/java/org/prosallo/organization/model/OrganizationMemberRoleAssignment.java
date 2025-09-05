package org.prosallo.organization.model;

import org.prosallo.core.domain.AggregateRoot;

public final class OrganizationMemberRoleAssignment extends AggregateRoot {

    private final OrganizationMember member;
    private final Role role;

    public OrganizationMemberRoleAssignment(OrganizationMember member, Role role) {
        this.member = member;
        this.role = role;
    }

    public static OrganizationMemberRoleAssignment create(OrganizationMember member, Role role) {
        return new OrganizationMemberRoleAssignment(member, role);
    }

    public OrganizationMember getMember() {
        return member;
    }

    public Role getRole() {
        return role;
    }
}
