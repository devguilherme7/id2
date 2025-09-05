package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.prosallo.core.infrastructure.entity.AbstractAuditableEntity;

@Entity
@Table(name = "organization_members")
public class OrganizationMemberEntity extends AbstractAuditableEntity {

    @Column(name = "user_id")
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
