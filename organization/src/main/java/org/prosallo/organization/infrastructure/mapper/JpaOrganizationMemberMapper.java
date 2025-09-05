package org.prosallo.organization.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.prosallo.core.infrastructure.configuration.GlobalMapperConfiguration;
import org.prosallo.organization.infrastructure.entity.OrganizationMemberEntity;
import org.prosallo.organization.model.OrganizationMember;

@Mapper(config = GlobalMapperConfiguration.class, uses = {JpaOrganizationMapper.class, JpaOrganizationMemberMapper.class})
public interface JpaOrganizationMemberMapper {

    OrganizationMember toDomain(OrganizationMemberEntity entity);

    OrganizationMemberEntity toEntity(OrganizationMember domain);
}
