package org.prosallo.organization.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.prosallo.core.infrastructure.configuration.GlobalMapperConfiguration;
import org.prosallo.organization.infrastructure.entity.OrganizationMemberPermissionSetAssignmentEntity;
import org.prosallo.organization.model.OrganizationMemberPermissionSetAssignment;

@Mapper(config = GlobalMapperConfiguration.class,
        uses = {JpaOrganizationMemberMapper.class, JpaPermissionSetMapper.class})
public interface JpaOrganizationMemberPermissionSetAssignmentMapper {

    OrganizationMemberPermissionSetAssignment toDomain(OrganizationMemberPermissionSetAssignmentEntity entity);

    OrganizationMemberPermissionSetAssignmentEntity toEntity(OrganizationMemberPermissionSetAssignment domain);
}
