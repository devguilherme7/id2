package org.prosallo.organization.model;

import org.prosallo.core.domain.AggregateRoot;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class OrganizationMember extends AggregateRoot {

    private final Organization organization;
    private final String userId;
    private final Set<Role> roles = new LinkedHashSet<>();

    public OrganizationMember(Organization organization, String userId) {
        this.organization = organization;
        this.userId = userId;
    }

    public static OrganizationMember create(Organization organization, String userId) {
        return new OrganizationMember(organization, userId);
    }

    public void assignRole(Role role) {
        this.roles.add(role);
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getUserId() {
        return userId;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(this.roles);
    }
}
