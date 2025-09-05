package org.prosallo.organization.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.prosallo.core.infrastructure.configuration.GlobalMapperConfiguration;
import org.prosallo.organization.infrastructure.entity.OrganizationMemberRoleAssignmentEntity;
import org.prosallo.organization.model.OrganizationMemberRoleAssignment;

@Mapper(config = GlobalMapperConfiguration.class)
public interface JpaOrganizationMemberRoleAssignmentMapper {

    OrganizationMemberRoleAssignment toDomain(OrganizationMemberRoleAssignmentEntity entity);

    OrganizationMemberRoleAssignmentEntity toEntity(OrganizationMemberRoleAssignment domain);
}
