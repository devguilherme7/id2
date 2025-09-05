package org.prosallo.organization.model;

import org.prosallo.core.domain.AggregateRoot;

public final class Role extends AggregateRoot {

    private final Organization organization;
    private final String name;

    public Role(Organization organization, String name) {
        this.organization = organization;
        this.name = name;
    }

    public static Role create(Organization organization, String name) {
        return new Role(organization, name);
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getName() {
        return name;
    }
}
