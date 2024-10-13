package com.jgji.selfassessment.global.config.security.token.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "token.jwt")
@Configuration
class JwtPropertiesImpl implements JwtProperties {

    private String secretKey;
    private long expirationMs;

    @Override
    public String getSecretKey() {
        return this.secretKey;
    }

    @Override
    public long getExpirationMs() {
        return this.expirationMs;
    }
}
