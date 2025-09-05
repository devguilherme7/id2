package org.prosallo.organization.model;

import lombok.Getter;
import org.prosallo.core.domain.AggregateRoot;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
public final class Organization extends AggregateRoot {

    private final String name;
    private final Set<OrganizationMember> members;

    public Organization(String name, Set<OrganizationMember> members) {
        this.name = name;
        this.members = members;
    }

    public static Organization create(String name) {
        return new Organization(name, new LinkedHashSet<>());
    }

    public void addMember(OrganizationMember member) {
        this.members.add(member);
    }
}
