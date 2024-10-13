package com.jgji.selfassessment.global.config.security.token.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "token.jwt")
@Configuration
class JwtPropertiesImpl implements JwtProperties {

    private Key key = new Key();
    private long expirationMs;

    @Override
    public String getSecret() {
        return this.key.getSecret();
    }

    @Override
    public long getExpirationMs() {
        return this.expirationMs;
    }

    private class Key {
        private String secret;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}
