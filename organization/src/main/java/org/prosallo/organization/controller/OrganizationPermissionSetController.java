package org.prosallo.organization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.prosallo.organization.data.PermissionSetRequest;
import org.prosallo.organization.data.PermissionSetResponse;
import org.prosallo.organization.model.PermissionSet;
import org.prosallo.organization.service.PermissionSetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organizations/{organizationId}/permission-sets")
@Tag(name = "Organization Permission Sets", description = "Organization permission sets management operations")
public class OrganizationPermissionSetController {

    private final PermissionSetService permissionSetService;

    public OrganizationPermissionSetController(PermissionSetService permissionSetService) {
        this.permissionSetService = permissionSetService;
    }

    @PostMapping
    @Operation(summary = "Create a new permission set for an organization")
    public ResponseEntity<PermissionSetResponse> create(@PathVariable Long organizationId,
            @Valid @RequestBody PermissionSetRequest request) {

        PermissionSet permissionSet = permissionSetService.createPermissionSet(organizationId, request.name());
        PermissionSetResponse response = new PermissionSetResponse(permissionSet.getId(), permissionSet.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}