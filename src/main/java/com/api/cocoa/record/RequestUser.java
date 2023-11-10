package com.api.cocoa.record;

import com.api.cocoa.user.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUser(
        Long id,
        @NotBlank @NotNull String name
        , @NotBlank @NotNull String email
        , @NotBlank @NotNull String password
                           ) {
}
