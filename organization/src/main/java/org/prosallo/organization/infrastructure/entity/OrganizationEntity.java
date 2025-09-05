package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.prosallo.core.infrastructure.entity.AbstractAuditableEntity;

@Entity
@Table(name = "organizations")
public class OrganizationEntity extends AbstractAuditableEntity {

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
