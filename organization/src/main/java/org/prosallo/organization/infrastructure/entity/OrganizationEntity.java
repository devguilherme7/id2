package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.prosallo.core.infrastructure.entity.AbstractAuditableEntity;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "organizations")
public class OrganizationEntity extends AbstractAuditableEntity {

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Set<OrganizationMemberEntity> members = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OrganizationMemberEntity> getMembers() {
        return members;
    }

    public void setMembers(Set<OrganizationMemberEntity> members) {
        this.members = members;
    }
}
