package org.prosallo.organization.model;

import org.prosallo.core.domain.AggregateRoot;

public final class OrganizationMember extends AggregateRoot {

    private final Organization organization;
    private final String userId;

    public OrganizationMember(Organization organization, String userId) {
        this.organization = organization;
        this.userId = userId;
    }

    public static OrganizationMember create(Organization organization, String userId) {
        return new OrganizationMember(organization, userId);
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getUserId() {
        return userId;
    }
}
