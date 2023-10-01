package com.praveen.blogapp.users.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class CreateUserRequest {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
