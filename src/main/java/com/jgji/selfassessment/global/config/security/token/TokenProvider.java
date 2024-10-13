package com.jgji.selfassessment.global.config.security.token;

public interface TokenProvider {

    String generateToken(String username);
    String getUsernameFromToken(String token);
    boolean validateToken(String authToken);
}
