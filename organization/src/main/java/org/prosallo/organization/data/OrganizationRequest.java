package org.prosallo.organization.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrganizationRequest(@NotBlank @Size(min = 3, max = 150) String name) {}
