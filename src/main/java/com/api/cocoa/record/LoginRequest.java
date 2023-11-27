package com.api.cocoa.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotBlank  String name, @NotBlank @NotNull String password) {
}
