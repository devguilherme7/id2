package org.prosallo.organization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.prosallo.organization.data.OrganizationRoleRequest;
import org.prosallo.organization.data.OrganizationRoleResponse;
import org.prosallo.organization.model.Role;
import org.prosallo.organization.service.OrganizationRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organizations/{organizationId}/roles")
@Tag(name = "Organization Roles", description = "Organization roles management operations")
public class OrganizationRoleController {

    private final OrganizationRoleService organizationRoleService;

    public OrganizationRoleController(OrganizationRoleService organizationRoleService) {
        this.organizationRoleService = organizationRoleService;
    }

    @PostMapping
    @Operation(summary = "Create a new role for an organization")
    public ResponseEntity<OrganizationRoleResponse> create(@PathVariable Long organizationId,
            @Valid @RequestBody OrganizationRoleRequest request) {

        Role role = organizationRoleService.createRole(organizationId, request.name());
        OrganizationRoleResponse response = new OrganizationRoleResponse(role.getId(), role.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
