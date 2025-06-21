package com.priyansh.fdAPI.security;

import lombok.Data;

@Data
public class JwtAuthResponse {
    String token; // The JWT generated after successful login.
    Integer userId;
}
