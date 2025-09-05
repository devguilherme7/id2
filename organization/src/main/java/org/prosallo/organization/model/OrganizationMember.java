package org.prosallo.organization.model;

import lombok.Getter;
import org.prosallo.core.domain.AggregateRoot;

@Getter
public final class OrganizationMember extends AggregateRoot {

    private final String userId;

    public OrganizationMember(String userId) {
        this.userId = userId;
    }

    public static OrganizationMember create(String userId) {
        return new OrganizationMember(userId);
    }
}
