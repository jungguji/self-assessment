package com.jgji.selfassessment.global.config.security.token;

public interface TokenProvider {

    String generateJwtToken(String username);
    String getUsernameFromJwtToken(String token);
    boolean validateJwtToken(String authToken);
}
