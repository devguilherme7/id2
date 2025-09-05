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
@Table(name = "organization_members")
public class OrganizationMemberEntity extends AbstractAuditableEntity {

    @Column(name = "user_id")
    private String userId;
}
