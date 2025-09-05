package org.prosallo.organization.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.prosallo.core.infrastructure.configuration.GlobalMapperConfiguration;
import org.prosallo.organization.infrastructure.entity.PermissionSetEntity;
import org.prosallo.organization.model.PermissionSet;

@Mapper(config = GlobalMapperConfiguration.class, uses = {JpaOrganizationMapper.class})
public interface JpaPermissionSetMapper {

    PermissionSet toDomain(PermissionSetEntity entity);

    PermissionSetEntity toEntity(PermissionSet domain);
}
