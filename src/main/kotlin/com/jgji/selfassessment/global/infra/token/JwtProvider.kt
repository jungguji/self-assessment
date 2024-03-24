package com.jgji.selfassessment.global.infra.token

import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtProvider : TokenProvider {

    private val jwtSecret = "mySecretKey" // 비밀키, 실제 환경에서는 외부에서 주입받아야 함
    private val jwtExpirationMs = 3600000L // 토큰 유효 시간 (예: 1시간)
    private val secretKey: SecretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(jwtSecret))

    fun generateJwt(username: String): String {
        return Jwts.builder()
            .subject(username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + jwtExpirationMs))
            .signWith(secretKey, Jwts.SIG.HS512)
            .compact();
    }

    fun getUsernameFromJwt(jwt: String): String {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(jwt)
            .payload
            .subject
    }

    fun validateJwt(authToken: String): Boolean {
        try {
            Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(authToken)
            return true;
        } catch (e: JwtException) {
            e.printStackTrace()
        }

        return false;
    }

}