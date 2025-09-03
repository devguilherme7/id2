package org.prosallo.organization.model;

import lombok.Getter;
import org.prosallo.core.domain.AggregateRoot;

@Getter
public final class Organization extends AggregateRoot {

    private final String name;

    public Organization(String name) {
        this.name = name;
    }

    public static Organization createNew(String name) {
        return new Organization(name);
    }
}
