package com.jgji.selfassessment.global.config.security.token;

import com.jgji.selfassessment.global.config.security.token.properties.JwtProperties;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
class JwtProvider implements TokenProvider {

    private final JwtProperties jwtProperties;
    private final Key key;
    private final long expirationMs;

    public JwtProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.key = Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
        this.expirationMs = jwtProperties.getExpirationMs();
    }

    public String generateJwtToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + expirationMs))
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            log.warn("토큰 검증 실패 : {}", authToken);
        }
        return false;
    }
}
