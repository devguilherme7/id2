package org.prosallo.organization.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.prosallo.core.infrastructure.configuration.GlobalMapperConfiguration;
import org.prosallo.organization.infrastructure.entity.RoleEntity;
import org.prosallo.organization.model.Role;

@Mapper(config = GlobalMapperConfiguration.class, uses = {JpaOrganizationMapper.class})
public interface JpaRoleMapper {

    Role toDomain(RoleEntity entity);

    RoleEntity toEntity(Role domain);
}
