package com.jgji.selfassessment.global.config.security.token.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "token.jwt")
@Configuration
class JwtPropertiesImpl implements JwtProperties {

    private String secretKey;
    private long expirationMs;
}
