package com.phuoc.identity_service.config;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JWTTokenFactory {

    public JWTClaimsSet createJWTClaimsSet(String username) {
        return new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("phuoc.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim", "Custom")
                .build();
    }
}
