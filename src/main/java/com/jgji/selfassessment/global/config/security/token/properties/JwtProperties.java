package com.jgji.selfassessment.global.config.security.token.properties;

public interface JwtProperties {
    String getSecretKey();
    long getExpirationMs();
}
