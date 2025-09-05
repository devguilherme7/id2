package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.prosallo.core.infrastructure.entity.AbstractPersistableEntity;

@Entity
@Table(name = "organization_member_role_assigments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"organization_member_id", "role_id"})
})
public class OrganizationMemberRoleAssignmentEntity extends AbstractPersistableEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_member_id", nullable = false, updatable = false)
    private OrganizationMemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false, updatable = false)
    private RoleEntity role;

    public OrganizationMemberEntity getMember() {
        return member;
    }

    public void setMember(OrganizationMemberEntity member) {
        this.member = member;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
