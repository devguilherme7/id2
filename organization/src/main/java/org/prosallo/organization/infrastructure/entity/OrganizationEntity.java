package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.prosallo.core.infrastructure.entity.AbstractAuditableEntity;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "organizations")
public class OrganizationEntity extends AbstractAuditableEntity {

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Set<OrganizationMemberEntity> members = new LinkedHashSet<>();
}
