package com.jgji.selfassessment.global.config.security.token.properties;

public interface JwtProperties {
    String getSecret();
    long getExpirationMs();
}
