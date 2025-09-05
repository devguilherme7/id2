package org.prosallo.organization.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.prosallo.core.infrastructure.entity.AbstractPersistableEntity;

@Entity
@Table(name = "organization_member_permission_set_assigments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"organization_member_id", "permission_set_id"})
})
public class OrganizationMemberPermissionSetAssignmentEntity extends AbstractPersistableEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_member_id", nullable = false, updatable = false)
    private OrganizationMemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permission_set_id", nullable = false, updatable = false)
    private PermissionSetEntity permissionSet;

    public OrganizationMemberEntity getMember() {
        return member;
    }

    public void setMember(OrganizationMemberEntity member) {
        this.member = member;
    }

    public PermissionSetEntity getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(PermissionSetEntity permissionSet) {
        this.permissionSet = permissionSet;
    }
}