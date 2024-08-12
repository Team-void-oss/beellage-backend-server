package com.oss.beellage.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {
    @Value("${jwt.access-expired}")
    private Long expiredTime;

    @Value("${jwt.access-expired}")
    private Long refreshExpiredTime;

    @Value("${jwt.secret-key}")
    private String secret;

    private SecretKey secretKey;

    @PostConstruct
    public void init() {
        secretKey = new SecretKeySpec(
                secret.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm()
        );
    }

    public Long getId(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("id", Long.class);
    }

    public boolean isExpired(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);  // "Bearer " 접두사 제거
        }

        try {
            return Jwts
                    .parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration()
                    .before(new Date());

        } catch (ExpiredJwtException e) {
            return false;
        }
    }

    public JWTTokens createJwt(Long userId) {
        String accessToken = "Bearer " + Jwts.builder()
                .header()
                .add("typ", "JWT")
                .and()

                .claim("id", userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredTime))
                .signWith(secretKey)
                .compact();

        String refreshToken = "Bearer " + Jwts.builder()
                .header()
                .add("typ", "JWT")
                .and()

                .claim("id", userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + refreshExpiredTime))
                .signWith(secretKey)
                .compact();

        return new JWTTokens(accessToken, refreshToken);
    }
}

