package com.priyansh.fdAPI.security;

import lombok.Data;

@Data
public class JwtAuthRequest {
    String username; // The username or email provided by the user.
    String password; // The plain-text password provided by the user.
}
