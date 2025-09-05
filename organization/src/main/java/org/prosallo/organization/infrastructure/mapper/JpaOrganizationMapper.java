package org.prosallo.organization.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.prosallo.core.infrastructure.configuration.GlobalMapperConfiguration;
import org.prosallo.organization.infrastructure.entity.OrganizationEntity;
import org.prosallo.organization.model.Organization;

@Mapper(config = GlobalMapperConfiguration.class)
public interface JpaOrganizationMapper {

    Organization toDomain(OrganizationEntity entity);

    OrganizationEntity toEntity(Organization organization);
}
