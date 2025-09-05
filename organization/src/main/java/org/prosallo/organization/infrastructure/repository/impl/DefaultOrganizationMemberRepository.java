package org.prosallo.organization.infrastructure.repository.impl;

import org.prosallo.organization.infrastructure.entity.OrganizationMemberEntity;
import org.prosallo.organization.infrastructure.mapper.JpaOrganizationMemberMapper;
import org.prosallo.organization.infrastructure.repository.JpaOrganizationMemberRepository;
import org.prosallo.organization.model.OrganizationMember;
import org.prosallo.organization.repository.OrganizationMemberRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultOrganizationMemberRepository implements OrganizationMemberRepository {

    private final JpaOrganizationMemberRepository jpaRepository;
    private final JpaOrganizationMemberMapper jpaMapper;

    public DefaultOrganizationMemberRepository(JpaOrganizationMemberRepository jpaRepository,
            JpaOrganizationMemberMapper jpaMapper) {
        this.jpaRepository = jpaRepository;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public OrganizationMember save(OrganizationMember organizationMember) {
        OrganizationMemberEntity entity = jpaMapper.toEntity(organizationMember);
        OrganizationMemberEntity savedEntity = jpaRepository.save(entity);
        return jpaMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<OrganizationMember> findByIdAndOrganizationId(Long id, Long organizationId) {
        return jpaRepository.findByIdAndOrganizationId(id, organizationId).map(jpaMapper::toDomain);
    }
}
