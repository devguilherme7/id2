package org.prosallo.organization.model;

import org.prosallo.core.domain.AggregateRoot;

public final class PermissionSet extends AggregateRoot {

    private final Organization organization;
    private final String name;

    public PermissionSet(Organization organization, String name) {
        this.organization = organization;
        this.name = name;
    }

    public static PermissionSet create(Organization organization, String name) {
        return new PermissionSet(organization, name);
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }
}