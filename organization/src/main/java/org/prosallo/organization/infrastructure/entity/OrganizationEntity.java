package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.prosallo.core.infrastructure.entity.AbstractAuditableEntity;

@Getter
@Setter
@Entity
@Table(name = "organizations")
public class OrganizationEntity extends AbstractAuditableEntity {

    @Column(name = "name", nullable = false, length = 150)
    private String name;
}
