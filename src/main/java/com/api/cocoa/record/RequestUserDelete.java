package com.api.cocoa.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUserDelete(
        @NotBlank @NotNull String name
        , @NotBlank @NotNull String email
        , @NotBlank @NotNull String password
                           ) {
}
