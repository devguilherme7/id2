package org.prosallo.organization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.prosallo.organization.data.AssignPermissionSetRequest;
import org.prosallo.organization.repository.OrganizationMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organizations/{organizationId}/members")
@Tag(name = "Organization Members", description = "Organization members management operations")
public class OrganizationMemberController {

    private final OrganizationMemberService organizationMemberService;

    public OrganizationMemberController(OrganizationMemberService organizationMemberService) {
        this.organizationMemberService = organizationMemberService;
    }

    @PostMapping("/{memberId}/permission-sets")
    @Operation(summary = "Assign a permission set to a member")
    public ResponseEntity<Void> assignPermissionSet(@PathVariable Long organizationId, @PathVariable Long memberId,
            @Valid @RequestBody AssignPermissionSetRequest request) {
        organizationMemberService.assignPermissionSet(organizationId, memberId, request.permissionSetId());
        return ResponseEntity.noContent().build();
    }
}
