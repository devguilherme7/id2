package org.prosallo.organization.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record AssignPermissionSetRequest(
        @Schema(description = "The ID of the permission set to assign")
        @NotNull
        Long permissionSetId) {}
