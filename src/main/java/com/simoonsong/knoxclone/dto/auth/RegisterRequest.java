package com.simoonsong.knoxclone.dto.auth;

public record RegisterRequest(
    String username,
    String password
) {}