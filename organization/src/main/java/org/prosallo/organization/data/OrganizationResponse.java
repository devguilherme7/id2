package org.prosallo.organization.data;

import io.swagger.v3.oas.annotations.media.Schema;

public record OrganizationResponse(
        @Schema(example = "751220344647407260")
        Long id,
        @Schema(example = "Acme Inc")
        String name) {}
